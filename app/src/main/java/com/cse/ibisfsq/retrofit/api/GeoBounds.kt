package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class GeoBounds(
    @SerializedName("circle")
    val circle: Circle?
)