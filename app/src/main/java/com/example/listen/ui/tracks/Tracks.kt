package com.example.listen.top_tracks

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.listen.viewmodel.TracksVM


@Composable
fun Tracks(viewModel: TracksVM, selected: String, navController: NavController) {
    viewModel.fetchData()
    val tracks by remember{ viewModel.tracks };

    Surface(Modifier.fillMaxSize()) {
        LazyColumn {
            try {
                if (selected.equals("Top Tracks")) {
                    tracks.forEach {
                        //renders Top Tracks
                        if (it.top_track) item {
                            TrackCard(
                                id = it.id,
                                musicName = it.name,
                                artist = it.artist,
                                cover = it.cover,
                                navController
                            )
                        }
                    }
                } else {
                    tracks.forEach {
                        //renders For you tracks
                        if (!it.top_track) item {
                            TrackCard(
                                id = it.id,
                                musicName = it.name,
                                artist = it.artist,
                                cover = it.cover,
                                navController
                            )
                        }
                    }
                }

            } catch (e: Exception) {
                Log.d("e==", e.message.toString())
            }
        }
    }
}


@Composable
fun TrackCard(id:Int,musicName: String, artist: String, cover: String, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .width(350.dp)
            .height(110.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = { navController.navigate("musicplayer/${id}") }),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )

    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp)
                    .clip(CircleShape)
                    .scale(2f)
                    .background(Color.Gray, shape = CircleShape),
                model = "https://cms.samespace.com/assets/${cover}",
                contentDescription = "bg",
            )

            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = musicName,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = artist,
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.White,
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewCard() {
//    TrackCard(musicName = "j", artist = "d", cover = "d")
//}


