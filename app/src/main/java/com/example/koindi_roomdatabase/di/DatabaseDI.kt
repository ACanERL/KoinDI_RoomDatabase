package com.example.koindi_roomdatabase.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.koindi_roomdatabase.db.NoteDatabase
import com.example.koindi_roomdatabase.utils.Constants.NOTE_DATABASE

fun provideDatabase(context: Context)=
    Room.databaseBuilder(context,NoteDatabase::class.java,NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db:NoteDatabase)=db.notDao()