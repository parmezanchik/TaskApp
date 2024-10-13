package com.example.mytaskapp.di

import androidx.room.Room
import com.example.mytaskapp.data.dp.AppDatabase
import com.example.mytaskapp.data.repository.TextRepository
import com.example.mytaskapp.data.repository.TextRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "my_task_database.db")
            .build()
    }

    single { get<AppDatabase>().textDao() }

    single<TextRepository> { TextRepositoryImpl(get()) }
}
