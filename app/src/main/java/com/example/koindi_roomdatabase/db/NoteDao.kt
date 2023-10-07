package com.example.koindi_roomdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koindi_roomdatabase.utils.Constants.NOTE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(noteEntity: NoteEntity)

    @Query("SELECT*FROM $NOTE_TABLE ORDER BY noteId DESC")
    fun getAllNotes(): Flow<MutableList<NoteEntity>>

}