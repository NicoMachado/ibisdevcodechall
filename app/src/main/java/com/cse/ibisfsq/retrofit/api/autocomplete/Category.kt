package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int?, // 13035
    @SerializedName("name")
    val name: String?, // Cafetería
    @SerializedName("icon")
    val icon: Icon?
)