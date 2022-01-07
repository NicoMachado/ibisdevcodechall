package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Center(
    @SerializedName("latitude")
    val latitude: Double?, // 47.6079325
    @SerializedName("longitude")
    val longitude: Double? // -122.34206449999999
)