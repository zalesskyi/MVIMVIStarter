package com.example.mvistarter.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvistarter.data.storage.dao.EntitiesDao
import com.example.mvistarter.data.storage.models.EntityDb

@Database(entities = [EntityDb::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photosDao(): EntitiesDao
}