package com.example.artmuseumapp.di

import com.example.artmuseumapp.viewmodel.ArtViewModel
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppModule {
    fun inject(viewModel: ArtViewModel)
}