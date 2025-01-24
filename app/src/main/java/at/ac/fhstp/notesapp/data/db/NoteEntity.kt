package at.ac.fhstp.notesapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val imageUri: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
