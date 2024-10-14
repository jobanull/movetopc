package com.example.myapplication.ldp.repository.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.databinding.RepoItemNewsBinding
import com.example.myapplication.ldp.repository.data.local.entity.RepoNewsEntity
import com.example.myapplication.ldp.repository.utils.RepoDateFormatter

class RepoNewsAdapter : ListAdapter<RepoNewsEntity, RepoNewsAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RepoItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    class MyViewHolder(val binding: RepoItemNewsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(news: RepoNewsEntity) {
            binding.tvItemTitle.text = news.title
            binding.tvItemPublishedDate.text = RepoDateFormatter.formatDate(news.publishedAt)
            Glide.with(itemView.context)
                .load(news.urlToImage)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(binding.imgPoster)
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(news.url)
                itemView.context.startActivity(intent)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<RepoNewsEntity> =
            object : DiffUtil.ItemCallback<RepoNewsEntity>() {
                override fun areItemsTheSame(oldItem: RepoNewsEntity, newItem: RepoNewsEntity): Boolean {
                    return oldItem.title == newItem.title
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: RepoNewsEntity, newItem: RepoNewsEntity): Boolean {
                    return oldItem == newItem
                }
            }
    }
}