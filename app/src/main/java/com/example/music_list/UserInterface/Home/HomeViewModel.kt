package com.example.music_list.UserInterface.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.music_list.Adapter.HomeAdapter
import com.example.music_list.DataManhwa
import com.example.music_list.Manhwa
import com.example.music_list.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    var number = 0

    init {
        Log.d("HomeViewModel", "HomeViewModel Created")
    }

    var listManhwa = arrayListOf<Manhwa>()

    interface onClickListener{
        fun onClick(manhwa: Manhwa)
    }

    fun getDataFromAPI(recyclerView: RecyclerView, listener: onClickListener){
        RetrofitClient.instance.getDataManhwa().enqueue(object : Callback<DataManhwa>{
            override fun onResponse(call: Call<DataManhwa>, response: Response<DataManhwa>) {
                val data = response.body()?.manhwas

                recyclerView.adapter = HomeAdapter(data as ArrayList<Manhwa>, object : HomeAdapter.OnItemClickListener{
                    override fun onClick(manhwa: Manhwa) {
                        listener.onClick(manhwa)
                    }

                })
            }

            override fun onFailure(call: Call<DataManhwa>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

        })
    }
}