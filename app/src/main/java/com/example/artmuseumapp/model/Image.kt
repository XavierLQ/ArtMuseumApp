package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("alttext")
    val alttext: Any,
    @SerializedName("baseimageurl")
    val baseimageurl: String,
    @SerializedName("caption")
    val caption: Any,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("displayorder")
    val displayorder: Int,
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("idsid")
    val idsid: Int,
    @SerializedName("iiifbaseuri")
    val iiifbaseuri: String,
    @SerializedName("imageid")
    val imageid: Int,
    @SerializedName("renditionnumber")
    val renditionnumber: String,
    @SerializedName("technique")
    val technique: Any,
    @SerializedName("width")
    val width: Int
)