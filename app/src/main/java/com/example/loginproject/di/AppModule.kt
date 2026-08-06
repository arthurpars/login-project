package com.example.loginproject.di

import com.example.loginproject.network.createHttpClient
import com.example.loginproject.repository.TodoRepository
import com.example.loginproject.validation.EmailValidator
import com.example.loginproject.validation.PasswordValidator
import com.example.loginproject.viewmodel.LoginViewModel
import com.example.loginproject.viewmodel.SignUpViewModel
import com.example.loginproject.viewmodel.TodoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { EmailValidator() }
    single { PasswordValidator() }
    single { createHttpClient() }
    single { TodoRepository(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { TodoViewModel(get()) }
}
