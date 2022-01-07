package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class FrontDoor(
    @SerializedName("latitude")
    val latitude: Double?, // 47.603439
    @SerializedName("longitude")
    val longitude: Double? // -122.332401
)