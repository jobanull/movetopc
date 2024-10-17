package com.example.myapplication.ldp.room

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.myapplication.ldp.room.database.RoomNote
import com.example.myapplication.ldp.room.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)
    fun insert(note: RoomNote) {
        mNoteRepository.insert(note)
    }
    fun update(note: RoomNote) {
        mNoteRepository.update(note)
    }
    fun delete(note: RoomNote) {
        mNoteRepository.delete(note)
    }
}