package at.ac.fhstp.notesapp.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import at.ac.fhstp.notesapp.data.Note
import coil.compose.rememberAsyncImagePainter

enum class Routes(val route: String) {
    Main("main"),
    AddEdit("addEdit/{noteId}")
}

@Composable
fun NotesApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Routes.Main.route) {
        composable(Routes.Main.route) {
            NotesListView(onAddNote = {
                navController.navigate("addEdit/-1")
            }, onEditNote = { noteId ->
                navController.navigate("addEdit/$noteId")
            })
        }
        composable(Routes.AddEdit.route, listOf(navArgument("noteId") {
            type = NavType.IntType
        })) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1
            AddEditNoteView(noteId = noteId, onSaveNote = {
                navController.popBackStack()
            })
        }
    }
}

@Composable
fun NotesListView(
    onAddNote: () -> Unit,
    onEditNote: (Int) -> Unit,
    notesViewModel: NotesViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    LaunchedEffect(Unit) {
        notesViewModel.updateSearchQuery("")
    }

    var searchQuery by remember { mutableStateOf("") }
    val notes by notesViewModel.filteredNotes.collectAsStateWithLifecycle()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNote,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Create, contentDescription = "Add Note")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                CustomOutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        notesViewModel.updateSearchQuery(it)
                    },
                    label = "Search Notes",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    contentPadding = PaddingValues(bottom = 72.dp)
                ) {
                    items(notes) { note ->
                        NoteListItem(
                            note = note,
                            onClick = { onEditNote(note.id) },
                            onDeleteNote = { notesViewModel.deleteNote(note) }
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun NoteListItem(
    note: Note,
    onClick: () -> Unit,
    onDeleteNote: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = if (note.content.length > 100) {
                        "${note.content.take(100)}..."
                    } else {
                        note.content
                    },
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
                note.imageUri?.let { uri ->
                    Image(
                        painter = rememberAsyncImagePainter(Uri.parse(uri)),
                        contentDescription = "Note Image",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 8.dp)
                    )
                }
            }
            IconButton(onClick = onDeleteNote) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Note", tint = MaterialTheme.colorScheme.error)
            }
        }
    }
}



@Composable
fun AddEditNoteView(
    noteId: Int,
    onSaveNote: () -> Unit,
    notesViewModel: NotesViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            context.contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            imageUri = uri.toString()
        }
    }

    LaunchedEffect(noteId) {
        if (noteId != -1) {
            notesViewModel.getNoteById(noteId)?.let { note ->
                title = note.title
                content = note.content
                imageUri = note.imageUri
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(16.dp)
    ) {
        CustomOutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = "Note Title",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Note Content") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { launcher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Pick Image", color = Color.White)
        }
        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(Uri.parse(it)),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val note = Note(
                    id = if (noteId == -1) 0 else noteId,
                    title = title,
                    content = content,
                    imageUri = imageUri
                )
                if (noteId == -1) {
                    notesViewModel.addNote(note)
                } else {
                    notesViewModel.updateNote(note)
                }
                onSaveNote()
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Save Note", color = Color.White)
        }
    }
}


@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, style = MaterialTheme.typography.labelMedium) },
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
        modifier = modifier,
        singleLine = true,
    )
}
