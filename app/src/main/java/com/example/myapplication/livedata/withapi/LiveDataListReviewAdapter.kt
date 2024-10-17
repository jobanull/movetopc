package com.example.myapplication.livedata.withapi

import LiveDataCustomerReviewsItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LivedataItemReviewBinding

class LiveDataListReviewAdapter : ListAdapter<LiveDataCustomerReviewsItem, LiveDataListReviewAdapter.MyViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LivedataItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val review = getItem(position)
        holder.bind(review)
    }
    class MyViewHolder(val binding: LivedataItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: LiveDataCustomerReviewsItem){
            binding.ldtvItem.text = "${review.review}\n- ${review.name}"
        }
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LiveDataCustomerReviewsItem>() {
            override fun areItemsTheSame(oldItem: LiveDataCustomerReviewsItem, newItem: LiveDataCustomerReviewsItem): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: LiveDataCustomerReviewsItem, newItem: LiveDataCustomerReviewsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}