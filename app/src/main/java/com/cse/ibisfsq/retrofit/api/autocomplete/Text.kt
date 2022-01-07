package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Text(
    @SerializedName("primary")
    val primary: String?, // Retro Coffee
    @SerializedName("secondary")
    val secondary: String?, // 920 5th Ave, Seattle, WA 98104
    @SerializedName("highlight")
    val highlight: List<Highlight>?
)