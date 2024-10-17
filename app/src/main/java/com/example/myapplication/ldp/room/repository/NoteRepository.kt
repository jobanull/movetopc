package com.example.myapplication.ldp.room.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.myapplication.ldp.room.database.RoomNote
import com.example.myapplication.ldp.room.database.NoteDao
import com.example.myapplication.ldp.room.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }
    fun getAllNotes(): LiveData<List<RoomNote>> = mNotesDao.getAllNotes()
    fun insert(note: RoomNote) {
        executorService.execute { mNotesDao.insert(note) }
    }
    fun delete(note: RoomNote) {
        executorService.execute { mNotesDao.delete(note) }
    }
    fun update(note: RoomNote) {
        executorService.execute { mNotesDao.update(note) }
    }
}