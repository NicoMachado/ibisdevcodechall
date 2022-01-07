package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Chain(
    @SerializedName("id")
    val id: String?, // ab4c54c0-d68a-012e-5619-003048cad9da
    @SerializedName("name")
    val name: String? // Starbucks
)