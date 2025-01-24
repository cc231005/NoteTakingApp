package at.ac.fhstp.notesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.ac.fhstp.notesapp.data.Note
import at.ac.fhstp.notesapp.data.NoteRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NoteRepository) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")

    val filteredNotes: StateFlow<List<Note>> = _searchQuery
        .flatMapLatest { query ->
            repository.searchNotes(query)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    suspend fun getNoteById(id: Int): Note? {
        return repository.notes.firstOrNull()?.find { it.id == id }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addOrUpdate(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.addOrUpdate(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }
}
