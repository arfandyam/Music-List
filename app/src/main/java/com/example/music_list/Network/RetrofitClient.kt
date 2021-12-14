package com.example.music_list.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val url_base = "https://manhwa.aerysh.xyz/"

    val instance : EndPointAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(url_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EndPointAPI::class.java)
    }
}