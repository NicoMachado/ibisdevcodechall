package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("latitude")
    val latitude: Double?, // 47.600152370806754
    @SerializedName("longitude")
    val longitude: Double? // -122.33094380272051
)