package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("begindate")
    val begindate: String,
    @SerializedName("color")
    val color: Any,
    @SerializedName("description")
    val description: Any,
    @SerializedName("enddate")
    val enddate: String,
    @SerializedName("exhibitionid")
    val exhibitionid: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("lastupdate")
    val lastupdate: String,
    @SerializedName("people")
    val people: List<People>,
    @SerializedName("poster")
    val poster: Poster,
    @SerializedName("primaryimageurl")
    val primaryimageurl: String,
    @SerializedName("shortdescription")
    val shortdescription: Any,
    @SerializedName("temporalorder")
    val temporalorder: Int,
    @SerializedName("textiledescription")
    val textiledescription: Any,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("venues")
    val venues: List<Venue>
)