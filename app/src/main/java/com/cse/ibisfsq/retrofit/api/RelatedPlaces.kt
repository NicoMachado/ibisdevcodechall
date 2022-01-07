package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class RelatedPlaces(
    @SerializedName("children")
    val children: List<Children>?
)