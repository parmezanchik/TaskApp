package com.example.mytaskapp.data.repository

import androidx.lifecycle.LiveData
import com.example.mytaskapp.data.dp.entity.TextEntity

interface TextRepository {
    suspend fun insertText(text: TextEntity)
    fun getAllTexts(): LiveData<List<TextEntity>>
}
