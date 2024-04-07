package com.example.listen.top_tracks

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.listen.viewmodel.TracksVM


@Composable
fun Tracks(viewModel: TracksVM) {
    viewModel.fetchData()
    val topTracks by viewModel.topTracks;

    Surface {
        LazyColumn {
            try {
                topTracks.forEach {
                   if(it.top_track) item { TrackCard(musicName = it.name, artist = it.artist, cover = it.cover) }
                }
            } catch (e: Exception) {
                Log.d("e==", e.message.toString())
            }
        }
    }
}


@Composable
fun TrackCard(musicName: String, artist: String, cover: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .width(350.dp)
            .height(110.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
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
                    text = "Colors",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "William King",
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.White,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    TrackCard(musicName = "j", artist = "d", cover = "d")
}


