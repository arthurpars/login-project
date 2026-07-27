package com.example.loginproject

import android.app.Application
import com.example.loginproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoginApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoginApplication)
            modules(appModule)
        }
    }
}
