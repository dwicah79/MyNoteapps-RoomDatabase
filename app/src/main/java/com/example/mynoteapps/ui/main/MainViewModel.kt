package com.example.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mynoteapps.DB.Note
import com.example.mynoteapps.Repository.NoteRepository

class MainViewModel(application: Application):ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes():LiveData<List<Note>> = mNoteRepository.getAllNotes()
}