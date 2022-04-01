package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Artworks(
    @SerializedName("info")
    val info: Info,
    @SerializedName("records")
    val records: List<Record>
)