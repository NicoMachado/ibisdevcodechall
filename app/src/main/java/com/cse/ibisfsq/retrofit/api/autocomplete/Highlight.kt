package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Highlight(
    @SerializedName("start")
    val start: Int?, // 6
    @SerializedName("length")
    val length: Int? // 4
)