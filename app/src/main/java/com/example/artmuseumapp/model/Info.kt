package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("next")
    val next: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("totalrecords")
    val totalrecords: Int,
    @SerializedName("totalrecordsperquery")
    val totalrecordsperquery: Int
)