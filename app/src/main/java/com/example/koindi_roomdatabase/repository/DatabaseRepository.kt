package com.example.koindi_roomdatabase.repository

import com.example.koindi_roomdatabase.db.NoteDao
import com.example.koindi_roomdatabase.db.NoteEntity

class DatabaseRepository(private val dao:NoteDao) {
    suspend fun saveNote(noteEntity: NoteEntity)=dao.saveNote(noteEntity)
    fun getAllNotes()=dao.getAllNotes()
}