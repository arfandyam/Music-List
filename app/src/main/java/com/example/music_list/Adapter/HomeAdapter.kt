package com.example.music_list.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.music_list.Manhwa
import com.example.music_list.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val listManhwa: ArrayList<Manhwa>, val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    interface OnItemClickListener{
        fun onClick(manhwa : Manhwa)
    }

    class Homeholder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(manhwa : Manhwa, listener: OnItemClickListener){
            with(itemView){

                Picasso.get()
                    .load(manhwa.thumbnail)
                    .into(thumbnail_img)

                titletv.text = manhwa.title
                latchptv.text = manhwa.latest_chapter

                itemView.setOnClickListener{
                    listener.onClick(manhwa)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Homeholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return Homeholder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.Homeholder, position: Int) {
        holder.bind(listManhwa[position], listener)
    }

    override fun getItemCount(): Int {
        return listManhwa.size
    }
}