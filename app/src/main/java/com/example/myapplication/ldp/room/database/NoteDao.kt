package com.example.myapplication.ldp.room.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: RoomNote)
    @Update
    fun update(note: RoomNote)
    @Delete
    fun delete(note: RoomNote)
    @Query("SELECT * from roomnote ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<RoomNote>>
}