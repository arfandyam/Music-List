package com.example.music_list

data class DataManhwa(
    val manhwas: List<Manhwa>,
    val message: String
)

data class Manhwa(
    val endpoint: String,
    val latest_chapter: String,
    val thumbnail: String,
    val title: String
)