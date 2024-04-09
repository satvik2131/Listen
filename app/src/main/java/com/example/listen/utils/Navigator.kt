package com.example.listen.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listen.ui.TracksList
import com.example.listen.ui.music_player.MusicPlayer

@Composable
fun AppNavigator() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = "tracks") {
        composable("tracks") { TracksList(navController) }
        composable("musicplayer/{id}"){backStackEntry -> MusicPlayer(navController,backStackEntry.arguments?.getString("id"))}
    }
}