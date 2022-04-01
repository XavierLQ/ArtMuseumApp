package com.example.artmuseumapp.model


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("address1")
    val address1: String,
    @SerializedName("address2")
    val address2: Any,
    @SerializedName("begindate")
    val begindate: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: Any,
    @SerializedName("enddate")
    val enddate: String,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("ishamvenue")
    val ishamvenue: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("venueid")
    val venueid: Int,
    @SerializedName("zipcode")
    val zipcode: String
)