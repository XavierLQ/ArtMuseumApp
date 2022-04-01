package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Poster(
    @SerializedName("caption")
    val caption: Any,
    @SerializedName("imageurl")
    val imageurl: String
)