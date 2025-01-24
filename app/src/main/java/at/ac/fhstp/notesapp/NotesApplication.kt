package at.ac.fhstp.notesapp

import android.app.Application
import at.ac.fhstp.notesapp.data.NoteRepository
import at.ac.fhstp.notesapp.data.db.NotesDatabase

class NotesApplication : Application() {
    val noteRepository by lazy {
        val notesDao = NotesDatabase.getDatabase(this).notesDao()
        NoteRepository(notesDao)
    }
}
