package com.example.listen.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listen.ui.TracksList

@Composable
fun AppNavigator() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = "tracks") {
        composable("tracks") { TracksList() }
    }
}