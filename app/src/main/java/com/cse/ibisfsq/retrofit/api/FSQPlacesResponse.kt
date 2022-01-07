package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class FSQPlacesResponse(
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("context")
    val context: Context?
)