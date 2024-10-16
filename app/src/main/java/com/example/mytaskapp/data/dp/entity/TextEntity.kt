package com.example.mytaskapp.data.dp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table")
data class TextEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String?
)
