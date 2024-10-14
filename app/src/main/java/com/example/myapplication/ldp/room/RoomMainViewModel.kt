package com.example.myapplication.ldp.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ldp.room.database.RoomNote
import com.example.myapplication.ldp.room.repository.NoteRepository

class RoomMainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)
    fun getAllNotes(): LiveData<List<RoomNote>> = mNoteRepository.getAllNotes()
}