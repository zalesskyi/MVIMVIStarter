package com.example.mvistarter.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entities")
data class EntityDb(@PrimaryKey val id: String)