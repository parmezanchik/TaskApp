package com.example.mytaskapp.app

import android.app.Application
import com.example.mytaskapp.di.appModule
import com.example.mytaskapp.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, viewModel)
        }
    }
}
