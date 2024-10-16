package com.example.mytaskapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytaskapp.data.dp.entity.TextEntity
import com.example.mytaskapp.data.repository.TextRepository
import kotlinx.coroutines.launch

class TextViewModel(private val repository: TextRepository) : ViewModel() {

    val lastText: MutableLiveData<TextEntity> = MutableLiveData<TextEntity>()
    val textList: LiveData<List<TextEntity>> = repository.getAllTexts()

    fun insertText(text: String) {
        viewModelScope.launch {
            val textEntity = TextEntity(text = text)
            kotlin.runCatching {
                repository.insertText(textEntity)
            }.onSuccess {
                lastText.value = textEntity
            }
        }
    }
}
