package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Geocodes(
    @SerializedName("main")
    val main: Main?,
    @SerializedName("front_door")
    val frontDoor: FrontDoor?
)