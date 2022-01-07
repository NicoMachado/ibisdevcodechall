package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("fsq_id")
    val fsqId: String?, // 5c5492f20a08ab002c82df3f
    @SerializedName("categories")
    val categories: List<Category>?,
    @SerializedName("distance")
    val distance: Int?, // 67
    @SerializedName("geocodes")
    val geocodes: Geocodes?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("name")
    val name: String? // Retro Coffee
)