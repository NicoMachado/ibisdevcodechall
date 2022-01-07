package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address")
    val address: String?, // 920 5th Ave
    @SerializedName("country")
    val country: String?, // US
    @SerializedName("cross_street")
    val crossStreet: String?,
    @SerializedName("dma")
    val dma: String?, // Seattle-Tacoma
    @SerializedName("locality")
    val locality: String?, // Seattle
    @SerializedName("neighborhood")
    val neighborhood: List<String>?,
    @SerializedName("postcode")
    val postcode: String?, // 98104
    @SerializedName("region")
    val region: String?, // WA
    @SerializedName("address_extended")
    val addressExtended: String? // Ste 314
)