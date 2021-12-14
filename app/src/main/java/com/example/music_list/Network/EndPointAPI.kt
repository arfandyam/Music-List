package com.example.music_list.Network

import com.example.music_list.DataManhwa
import retrofit2.Call
import retrofit2.http.GET

interface EndPointAPI {

    @GET("all/1")
    fun getDataManhwa() : Call<DataManhwa>
}