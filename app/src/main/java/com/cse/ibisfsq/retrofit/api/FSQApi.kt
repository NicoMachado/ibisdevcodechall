package com.cse.ibisfsq.retrofit.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FSQApi {
    //V2 is deprecated !
    //@GET("/v2/venues/search?client_id=04KMTPOGIXGF01HGPFD5XC20BPJ0S4GGL4JV3MSYQ3AZCDIZ&client_secret=PIV55FHY0LLWDPGD30VNVDAC0WAGBFOQVJCRMV2I3NVPXQLC&near=Seattle%2C%20%2BWA&limit=20&v=20220101")
    //fun getVenues(@Query("query") query: String): Call<FSQPlacesResponse>

    //Auth Data should be in properties file!
    //"Authorization: fsq3yHqHfaSZSlHHYUpvH3UobKWOYCX7ziom5QjmPOADhOw="
    //fsq3NvswjYlhO8h3J1B6usxyrkssNLlLyUG6nOjTk3XkLhM=
    @Headers( value = [
            "Accept: application/json",
            "Authorization: fsq3NvswjYlhO8h3J1B6usxyrkssNLlLyUG6nOjTk3XkLhM="
            ])
    @GET("v3/places/search?near=Seattle%2C%2BWA&limit=20")
    suspend fun getPlaces(@Query("query") query: String): Response<FSQPlacesResponse>


    @GET("v3/autocomplete")
    suspend fun autocomplete()
}