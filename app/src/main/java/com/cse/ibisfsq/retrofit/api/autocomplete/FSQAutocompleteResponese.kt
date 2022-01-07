package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class FSQAutocompleteResponese(
    @SerializedName("results")
    val results: List<Result>?
)