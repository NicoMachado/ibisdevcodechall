package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Context(
    @SerializedName("geo_bounds")
    val geoBounds: GeoBounds?
)