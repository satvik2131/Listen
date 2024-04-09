package com.example.listen.ui.music_player

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.listen.model.utils.Music
import com.example.listen.utils.retrofit.ApiService
import com.example.listen.utils.retrofit.RetrofitInstance
import com.example.listen.viewmodel.TracksVM

@Composable
fun MusicPlayer(navController: NavController, id: String?, api: ApiService = RetrofitInstance.api) {
    val viewModel: TracksVM = TracksVM(api);
    viewModel.fetchData();
    val tracks by remember { viewModel.tracks };

    Column {
        MusicCoverPager(id = id, tracks = tracks)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MusicCoverPager(id: String?, tracks: List<Music>) {
    val BASE_URL: String = "https://cms.samespace.com/assets/"
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    if (id != null && !tracks.isEmpty()) {
        val prev = tracks.get(id.toInt() - 1);
        val current = tracks.get(id.toInt());
        val next = tracks.get(id.toInt() + 1);
        val imageModifier: Modifier = Modifier.size(304.dp).scale(2f)

        HorizontalPager(state = pagerState) {
            AsyncImage(
                model = "$BASE_URL${prev.cover}",
                contentDescription = "kk",
                modifier = imageModifier
            )

            AsyncImage(
                model = "$BASE_URL${current.cover}",
                contentDescription = "kk",
                modifier = imageModifier
            )
            AsyncImage(
                model = "$BASE_URL${next.cover}",
                contentDescription = "kk",
                modifier = imageModifier
            )
        }
    }
}
