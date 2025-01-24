package at.ac.fhstp.notesapp.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import at.ac.fhstp.notesapp.NotesApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val notesApplication = this[APPLICATION_KEY] as NotesApplication
            NotesViewModel(notesApplication.noteRepository)
        }
    }
}
