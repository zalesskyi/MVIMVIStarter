package com.example.mvistarter.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvistarter.data.storage.models.EntityDb

@Dao
interface EntitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: EntityDb)

    @Query("SELECT * FROM entities")
    suspend fun getAll(): List<EntityDb>
}