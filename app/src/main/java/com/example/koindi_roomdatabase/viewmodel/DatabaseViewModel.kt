package com.example.koindi_roomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koindi_roomdatabase.db.NoteEntity
import com.example.koindi_roomdatabase.repository.DatabaseRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DatabaseRepository):ViewModel() {
    private val _noteList=MutableLiveData<List<NoteEntity>>()
    val noteList:LiveData<List<NoteEntity>>
        get() = _noteList

    fun getAllNotes()=viewModelScope.launch {
        repository.getAllNotes().collect{
            _noteList.postValue(it)
        }
    }

    fun saveNote(note:NoteEntity)=viewModelScope.launch {
        repository.saveNote(note)
    }
}