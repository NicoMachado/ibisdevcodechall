package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("fsq_id")
    val fsqId: String?, // 5a020ad26fd62646ba6f6f90
    @SerializedName("name")
    val name: String? // Princi
)