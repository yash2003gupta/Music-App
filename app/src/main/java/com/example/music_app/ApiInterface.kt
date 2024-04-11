package com.example.music_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: 10bad49478msh79f1815c7b3f697p1ff941jsn4a65d8502e39",
    "X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query:String): Call<MyData>

}