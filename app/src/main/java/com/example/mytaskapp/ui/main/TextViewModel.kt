package com.example.mytaskapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytaskapp.data.dp.entity.TextEntity
import com.example.mytaskapp.data.repository.TextRepository
import kotlinx.coroutines.launch

class TextViewModel(private val repository: TextRepository) : ViewModel() {

    private val _lastText = MutableLiveData<TextEntity>()
    val lastText: LiveData<TextEntity> = _lastText

    val textList: LiveData<List<TextEntity>> = repository.getAllTexts()

    fun insertText(text: String) {
        viewModelScope.launch {
            val textEntity = createTextEntity(text)
            kotlin.runCatching {
                repository.insertText(textEntity)
            }.onSuccess {
                _lastText.value = textEntity
            }.onFailure {
            }
        }
    }

    private fun createTextEntity(text: String): TextEntity {
        return TextEntity(text = text)
    }
}
