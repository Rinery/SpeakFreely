package com.example.speakfreely.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.speakfreely.app.ui.theme.SpeakFreelyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // экран растягивается от края до края
        setContent {
            SpeakFreelyTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        Scaffold(
            bottomBar = {

            }
        ) {

        }
    }

    @Composable
    fun BottomNavigationBar(navController) {

    }
}