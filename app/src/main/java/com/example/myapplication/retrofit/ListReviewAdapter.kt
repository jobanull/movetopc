package com.example.myapplication.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RetrofitItemReviewBinding
import com.example.myapplication.retrofit.data.response.RetrofitCustomerReviewsItem

class ListReviewAdapter : ListAdapter<RetrofitCustomerReviewsItem, ListReviewAdapter.MyViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RetrofitItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val review = getItem(position)
        holder.bind(review)
    }
    class MyViewHolder(val binding: RetrofitItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: RetrofitCustomerReviewsItem){
            binding.tvItem.text = "${review.review}\n- ${review.name}"
        }
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RetrofitCustomerReviewsItem>() {
            override fun areItemsTheSame(oldItem: RetrofitCustomerReviewsItem, newItem: RetrofitCustomerReviewsItem): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: RetrofitCustomerReviewsItem, newItem: RetrofitCustomerReviewsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}