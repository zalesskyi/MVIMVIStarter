package com.example.mvistarter.data.storage

import android.content.Context
import androidx.room.Room

object AppDatabaseCreator {

    private const val DATABASE_NAME = "entities.db"

    lateinit var database: AppDatabase

    fun createDatabase(context: Context) {
        database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }
}