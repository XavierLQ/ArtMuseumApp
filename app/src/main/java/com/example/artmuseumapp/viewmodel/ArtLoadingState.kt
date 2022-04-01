package com.example.artmuseumapp.viewmodel

sealed class ArtLoadingState {
    object LOADING : ArtLoadingState()
    class SUCCESS<T>(val response: T) : ArtLoadingState()
    class ERROR(val error: Throwable) : ArtLoadingState()
}