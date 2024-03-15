package com.example.mynoteapps.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mynoteapps.DB.Note
import com.example.mynoteapps.DB.NoteDAO
import com.example.mynoteapps.DB.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application){
    private val mNotesDao:NoteDAO
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDAO()
    }

    fun getAllNotes():LiveData<List<Note>> = mNotesDao.getALLNotes()

    fun insert(note: Note){
        executorService.execute{mNotesDao.insert(note)}
    }

    fun delete(note: Note){
        executorService.execute{mNotesDao.delete(note)}
    }
    fun update(note: Note){
        executorService.execute{mNotesDao.update(note)}
    }
}