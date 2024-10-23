package com.example.mytaskapp.data.dp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mytaskapp.data.dp.entity.TextEntity

@Dao
interface TextDao {
    @Insert
    suspend fun insert(text: TextEntity)

    @Query("SELECT * FROM text_table ORDER BY id DESC")
    fun getAllTexts(): LiveData<List<TextEntity>>

    @Query("SELECT * FROM text_table ORDER BY id DESC LIMIT 1")
    fun getLastText(): LiveData<TextEntity>
}

