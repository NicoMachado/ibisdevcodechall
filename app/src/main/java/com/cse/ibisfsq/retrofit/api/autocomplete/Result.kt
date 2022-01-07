package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("type")
    val type: String?, // place
    @SerializedName("text")
    val text: Text?,
    @SerializedName("link")
    val link: String?, // /v3/places/5c5492f20a08ab002c82df3f
    @SerializedName("place")
    val place: Place?,
    @SerializedName("search")
    val search: Search?
)