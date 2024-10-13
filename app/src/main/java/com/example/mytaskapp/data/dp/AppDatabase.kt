package com.example.mytaskapp.data.dp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytaskapp.data.dp.dao.TextDao
import com.example.mytaskapp.data.dp.entity.TextEntity

@Database(entities = [TextEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao
}
