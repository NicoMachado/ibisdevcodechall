package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Chain(
    @SerializedName("id")
    val id: String?, // e60a5d2d-6e9e-4d3b-bfe4-5cebfc0c3d97
    @SerializedName("name")
    val name: String? // Peet's Coffee and Tea
)