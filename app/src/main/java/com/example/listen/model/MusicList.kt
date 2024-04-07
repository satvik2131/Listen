package com.example.listen.model

import com.example.listen.model.utils.Music
import com.google.gson.annotations.SerializedName

data class MusicList(
    @SerializedName("data")
    val data: List<Music>
)