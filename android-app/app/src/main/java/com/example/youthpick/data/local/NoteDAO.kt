package com.example.youthpick.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteDAO {
    @Insert(onConflict = REPLACE)
    fun insert(noteEntity: NoteEntity)

    @Query("SELECT * FROM note")
    fun getAllNote() : List<NoteEntity>

    @Delete
    fun delete(noteEntity: NoteEntity)
}