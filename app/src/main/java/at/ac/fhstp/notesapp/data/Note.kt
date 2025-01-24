package at.ac.fhstp.notesapp.data

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val imageUri: String? = null
)