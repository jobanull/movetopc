package com.example.myapplication.loopj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ListQuoteAdapter(private val listReview: ArrayList<String>) : RecyclerView.Adapter<ListQuoteAdapter.ViewHolder>() {

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val tvItem : TextView = view.findViewById(R.id.retrofit_tvItem)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.loopj_item_quote, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = listReview[position]
    }

    override fun getItemCount(): Int {
        return listReview.size
    }

}