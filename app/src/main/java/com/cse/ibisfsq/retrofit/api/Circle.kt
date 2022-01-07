package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Circle(
    @SerializedName("center")
    val center: Center?,
    @SerializedName("radius")
    val radius: Int? // 16564
)