package com.example.artmuseumapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.artmuseumapp.rest.ArtRepository
import javax.inject.Inject

class ArtViewModel @Inject constructor(
    val artRepo:ArtRepository
): ViewModel() {


}