package com.example.listen.model.utils

//data class Music (
//        val name:String,
//        val artist:String,
//        val cover_id:String,
//        val accent : String,
//        val top_track : Boolean
//)


data class Music(
        val id: Int,
        val status: String,
        val sort: Int?, // Note: sort can be nullable
        val user_created: String,
        val date_created: String,
        val user_updated: String,
        val date_updated: String,
        val name: String,
        val artist: String,
        val accent: String,
        val cover: String,
        val top_track: Boolean,
        val url: String
)