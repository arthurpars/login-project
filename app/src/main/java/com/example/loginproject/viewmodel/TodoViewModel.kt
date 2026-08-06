package com.example.loginproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginproject.data.TodoDto
import com.example.loginproject.repository.TodoRepository
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data object Loading : TodoUiState
    data class Success(val todo: TodoDto) : TodoUiState
    data class Error(val message: String) : TodoUiState
}

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    var uiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)
        private set

    init {
        loadTodo()
    }

    fun loadTodo() {
        uiState = TodoUiState.Loading
        viewModelScope.launch {
            uiState = repository.getTodo().fold(
                onSuccess = { TodoUiState.Success(it) },
                onFailure = { TodoUiState.Error(it.message ?: "Something went wrong") }
            )
        }
    }
}
