package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("fsq_id")
    val fsqId: String?, // 545803de498e7e758ac5605e
    @SerializedName("categories")
    val categories: List<Category>?,
    @SerializedName("chains")
    val chains: List<Chain>?,
    @SerializedName("distance")
    val distance: Int?, // 1200
    @SerializedName("geocodes")
    val geocodes: Geocodes?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("name")
    val name: String?, // Elm Coffee Roaste
    @SerializedName("related_places")
    val relatedPlaces: RelatedPlaces?,
    @SerializedName("timezone")
    val timezone: String? // America/Los_Angeles
)