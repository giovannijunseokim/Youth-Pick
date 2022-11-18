package com.example.youthpick.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Long?,
    var noteTitle : String = "",
    var noteDesc : String = ""
)
