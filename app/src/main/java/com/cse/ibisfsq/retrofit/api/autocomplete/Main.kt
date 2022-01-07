package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("latitude")
    val latitude: Double?, // 47.606662
    @SerializedName("longitude")
    val longitude: Double? // -122.331461
)