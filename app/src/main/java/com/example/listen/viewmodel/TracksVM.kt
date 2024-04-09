package com.example.listen.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listen.model.MusicList
import com.example.listen.model.utils.Music
import com.example.listen.utils.retrofit.ApiService
import com.example.listen.utils.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class TracksVM(val apiService: ApiService = RetrofitInstance.api) : ViewModel() {
    val tracks:MutableState<List<Music>> = mutableStateOf(emptyList<Music>())

    fun fetchData() {
        viewModelScope.launch {
            try {
                val resp: Response<MusicList> = apiService.getListOfTopTracks();
                if (resp.isSuccessful) {
                    tracks.value = resp.body()?.data!!;
                }
            } catch (e: Exception) {
                Log.d("err--", e.message.toString())
            }
        }
    }
}
