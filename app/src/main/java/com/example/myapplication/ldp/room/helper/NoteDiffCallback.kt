package com.example.myapplication.ldp.room.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.ldp.room.database.RoomNote

class NoteDiffCallback(private val oldNoteList: List<RoomNote>, private val newNoteList: List<RoomNote>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldNoteList.size
    override fun getNewListSize(): Int = newNoteList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNoteList[oldItemPosition].id == newNoteList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldNote = oldNoteList[oldItemPosition]
        val newNote = newNoteList[newItemPosition]
        return oldNote.title == newNote.title && oldNote.description == newNote.description
    }
}