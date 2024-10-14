package com.example.myapplication.ldp.repository.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.ldp.repository.data.local.entity.RepoNewsEntity

@Dao
interface RepoNewsDao {
    @Query("SELECT * FROM news ORDER BY publishedAt DESC")
    fun getNews(): LiveData<List<RepoNewsEntity>>

    @Query("SELECT * FROM news where bookmarked = 1")
    fun getBookmarkedNews(): LiveData<List<RepoNewsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(news: List<RepoNewsEntity>)

    @Update
    fun updateNews(news: RepoNewsEntity)

    @Query("DELETE FROM news WHERE bookmarked = 0")
    fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM news WHERE title = :title AND bookmarked = 1)")
    fun isNewsBookmarked(title: String): Boolean
}