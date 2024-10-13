package com.example.mytaskapp.di

import com.example.mytaskapp.ui.main.TextViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { TextViewModel(get()) }
}