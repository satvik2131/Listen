package com.example.listen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.listen.components.BottomNavigation
import com.example.listen.components.ResizableText
import com.example.listen.top_tracks.Tracks
import com.example.listen.utils.retrofit.RetrofitInstance
import com.example.listen.viewmodel.TracksVM

@Composable
fun TracksList(navController: NavController) {
    val api = RetrofitInstance.api;
    val viewModel: TracksVM = TracksVM(api);
    val (selected, setSelected) = remember { mutableStateOf("For You") }

    Scaffold(bottomBar = {
        BottomAppBar {
            BottomNavigation(selected, setSelected)
        }
    }) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Tracks(viewModel = viewModel, selected,navController)
        }
    }
}

//
//@Preview
//@Composable
//fun TrackListPreview() {
//    TracksList(navController = rememberNavController())
//}