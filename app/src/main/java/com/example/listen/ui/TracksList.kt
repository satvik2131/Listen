package com.example.listen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listen.top_tracks.Tracks
import com.example.listen.utils.retrofit.RetrofitInstance
import com.example.listen.viewmodel.TracksVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TracksList() {
    val api = RetrofitInstance.api;
    val viewModel: TracksVM = TracksVM(api);

    Scaffold(bottomBar = {
        BottomAppBar() {
            BottomNavigation()
        }
    }) {
        Column(Modifier.fillMaxSize()) {
            Tracks(viewModel = viewModel)
        }
    }
}


@Composable
fun BottomNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Column(modifier = Modifier
            .width(50.dp)
            .align(Alignment.Top)) {
            Text("For You", modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                ".",
                Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,

                )
        }
        Column(modifier = Modifier
            .width(70.dp)
            .align(Alignment.Top)) {
            Text("Top Tracks")
            Text(
                ".", Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Composable
fun BottomContent() {
    BottomAppBar {

    }
}

@Preview
@Composable
fun TrackListPreview() {
    TracksList()
}