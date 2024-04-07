package com.example.listen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.listen.ui.theme.ListenTheme
import com.example.listen.utils.AppNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListenTheme {
                AppNavigator();
            }
        }
    }
}

