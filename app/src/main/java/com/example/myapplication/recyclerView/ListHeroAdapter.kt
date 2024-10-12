package com.example.myapplication.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.RecyclerviewItemRowHeroBinding

class ListHeroAdapter (private val listHero : ArrayList<Hero>) :RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: RecyclerviewItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback{
        fun onItemClicked(data : Hero)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RecyclerviewItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listHero.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listHero[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = desc
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }
}