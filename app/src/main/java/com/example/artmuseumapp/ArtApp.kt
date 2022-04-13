package com.example.artmuseumapp

import android.app.Application
import com.example.artmuseumapp.di.NetworkModule
import com.example.artmuseumapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArtApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ArtApp)
            modules(listOf(NetworkModule, viewModelModule))
        }
    }}