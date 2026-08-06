package com.example.loginproject.repository

import com.example.loginproject.data.TodoDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val TODO_URL = "https://jsonplaceholder.typicode.com/todos/1"

class TodoRepository(private val httpClient: HttpClient) {

    suspend fun getTodo(): Result<TodoDto> = runCatching {
        httpClient.get(TODO_URL).body()
    }
}
