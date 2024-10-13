package com.example.mytaskapp.data.repository

import com.example.mytaskapp.data.dp.dao.TextDao
import com.example.mytaskapp.data.dp.entity.TextEntity

class TextRepositoryImpl(
    private val textDao: TextDao
) : TextRepository {
    override suspend fun insertText(text: TextEntity) {
        val entity = TextEntity(text = text.text)
        textDao.insert(entity)
    }
}