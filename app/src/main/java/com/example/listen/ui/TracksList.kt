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
import com.example.listen.components.ResizableText
import com.example.listen.top_tracks.Tracks
import com.example.listen.utils.retrofit.RetrofitInstance
import com.example.listen.viewmodel.TracksVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TracksList() {
    val api = RetrofitInstance.api;
    val viewModel: TracksVM = TracksVM(api);

    Scaffold(bottomBar = {
        BottomAppBar {
            BottomNavigation()

        }
    }) {
        Column(Modifier.fillMaxSize().padding(it)) {
            Tracks(viewModel = viewModel)
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun BottomNavigation() {
    val (selected, setSelected) = remember { mutableStateOf("For You") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        NavItem("For You", selected, setSelected)
        NavItem("Top Tracks", selected, setSelected)
    }
}

@Composable
fun NavItem(label: String, selected: String, setSelected: (String) -> Unit) {
//    val (color, setColor) = remember { mutableStateOf(Color(0XFF878686)) }
    var color: Color;
    if (label.equals(selected)) color = MaterialTheme.colorScheme.onPrimary else color =
        Color(0XFF878686)



    Box(
        modifier = Modifier.clickable(
            onClick = { setSelected(label) },
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        )
    ) {
        Column {
            ResizableText(
                text = label,
                color = color,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(9.dp))

            if (label.equals(selected))
                Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                    DotIcon()
                }

        }
    }

}

@Composable
fun DotIcon(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    size: Dp = 8.dp
) {
    Canvas(
        modifier = Modifier.size(size)
    ) {
        drawCircle(color = color)
    }
}


@Preview
@Composable
fun TrackListPreview() {
    TracksList()
}