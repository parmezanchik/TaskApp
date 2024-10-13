package com.example.mytaskapp.data.repository

import com.example.mytaskapp.data.dp.entity.TextEntity

interface TextRepository {
    suspend fun insertText(text: TextEntity)
}
