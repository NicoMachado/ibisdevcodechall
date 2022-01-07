package com.cse.ibisfsq.retrofit.api.autocomplete


import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("query")
    val query: String?, // coffee cake
    @SerializedName("category")
    val category: CategoryX?,
    @SerializedName("chain")
    val chain: Chain?
)