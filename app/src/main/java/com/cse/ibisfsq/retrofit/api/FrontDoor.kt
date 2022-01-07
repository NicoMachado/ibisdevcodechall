package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class FrontDoor(
    @SerializedName("latitude")
    val latitude: Double?, // 47.612281
    @SerializedName("longitude")
    val longitude: Double? // -122.333809
)