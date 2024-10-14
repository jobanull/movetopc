package com.example.myapplication.ldp.repository.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.ldp.repository.data.local.entity.RepoNewsEntity


@Database(entities = [RepoNewsEntity::class], version = 1, exportSchema = false)
abstract class RepoNewsDatabase : RoomDatabase() {
    abstract fun newsDao(): RepoNewsDao

    companion object {
        @Volatile
        private var instance: RepoNewsDatabase? = null
        fun getInstance(context: Context): RepoNewsDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    RepoNewsDatabase::class.java, "News.db"
                ).build()
            }
    }
}