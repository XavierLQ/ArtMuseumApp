package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("displayname")
    val displayname: String,
    @SerializedName("displayorder")
    val displayorder: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("personid")
    val personid: Int,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("role")
    val role: String
)