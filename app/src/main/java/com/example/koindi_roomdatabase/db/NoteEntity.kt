package com.example.koindi_roomdatabase.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.koindi_roomdatabase.utils.Constants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var noteId :Int =0,

    @ColumnInfo(name = "note_title")
    var noteTitle:String="",

    @ColumnInfo(name = "note_desc")
    var noteDesc : String=""

)
