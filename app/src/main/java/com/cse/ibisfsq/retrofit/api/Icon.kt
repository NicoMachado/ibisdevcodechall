package com.cse.ibisfsq.retrofit.api


import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("prefix")
    val prefix: String?, // https://ss3.4sqi.net/img/categories_v2/food/coffeeshop_
    @SerializedName("suffix")
    val suffix: String? // .png
)