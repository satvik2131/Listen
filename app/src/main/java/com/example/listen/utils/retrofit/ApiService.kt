package com.example.listen.utils.retrofit

import androidx.compose.runtime.MutableState
import com.example.listen.model.MusicList
import com.example.listen.model.utils.Music
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/items/songs")
    suspend fun getListOfTopTracks(): Response<MusicList>

    @GET("your_endpoint")
    suspend fun getListOfForYouMusic():List <Music>
}