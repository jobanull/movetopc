package com.example.myapplication.ldp.room

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RoomItemNoteBinding
import com.example.myapplication.ldp.room.database.RoomNote
import com.example.myapplication.ldp.room.helper.NoteDiffCallback

class RoomNoteAdapter : RecyclerView.Adapter<RoomNoteAdapter.NoteViewHolder>() {
    private val listNotes = ArrayList<RoomNote>()
    fun setListNotes(listNotes: List<RoomNote>) {
        val diffCallback = NoteDiffCallback(this.listNotes, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNotes.clear()
        this.listNotes.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = RoomItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }
    override fun getItemCount(): Int {
        return listNotes.size
    }
    inner class NoteViewHolder(private val binding: RoomItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: RoomNote) {
            with(binding) {
                tvItemTitle.text = note.title
                tvItemDate.text = note.date
                tvItemDescription.text = note.description
                cvItemNote.setOnClickListener {
                    val intent = Intent(it.context, RoomNoteAddUpdateActivity::class.java)
                    intent.putExtra(RoomNoteAddUpdateActivity.EXTRA_NOTE, note)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}