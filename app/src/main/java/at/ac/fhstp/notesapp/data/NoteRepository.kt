package at.ac.fhstp.notesapp.data

import at.ac.fhstp.notesapp.data.db.NoteEntity
import at.ac.fhstp.notesapp.data.db.NotesDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepository(private val notesDao: NotesDao) {
    val notes: Flow<List<Note>> = notesDao.getAllNotes().map { entities ->
        entities.map { entity -> Note(entity.id, entity.title, entity.content, entity.imageUri) }
    }

    fun searchNotes(query: String): Flow<List<Note>> {
        return notesDao.searchNotes(query).map { entities ->
            entities.map { entity -> Note(entity.id, entity.title, entity.content, entity.imageUri) }
        }
    }

    suspend fun addOrUpdate(note: Note) {
        notesDao.insert(NoteEntity(note.id, note.title, note.content, note.imageUri))
    }

    suspend fun delete(note: Note) {
        notesDao.delete(NoteEntity(note.id, note.title, note.content, note.imageUri))
    }
}
