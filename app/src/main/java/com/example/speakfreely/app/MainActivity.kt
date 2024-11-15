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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // экран растягивается от края до края
        setContent {
            SpeakFreelyTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { innerPadding ->

                }
            }
        }
    }
//    @Composable
//    fun BottomNavigationBar () {
//        BottomNavigation(
//            backgroundColor = MaterialTheme.colors.primarySurface,
//            contentColor = MaterialTheme.colors.onPrimary
//        ) {
//            BottomNavigationItem (
//                icon = {
//                    Icon(
//                        ImageVector.vectorResource(id = R.drawable.ic_chat),
//                        contentDescription = "Chat"
//                    )
//                },
//                selected = false,
//                onClick = {
//
//                }
//            )
//            BottomNavigationItem (
//                icon = {
//                    Icon(
//                        ImageVector.vectorResource(id = R.drawable.ic_camera),
//                                contentDescription = "Camera"
//                    )
//                },
//                selected = false,
//                onClick = {
//
//                }
//            )
//            BottomNavigationItem (
//                icon = {
//                    Icon(
//                        ImageVector.vectorResource(id = R.drawable.ic_translate),
//                                contentDescription = "Translate "
//                    )
//                },
//                selected = false,
//                onClick = {
//
//                }
//            )
//            BottomNavigationItem (
//                icon = {
//                    Icon(
//                        ImageVector.vectorResource(id = R.drawable.ic_history),
//                                contentDescription = "History"
//                    )
//                },
//                selected = false,
//                onClick = {
//
//                }
//            )
//            BottomNavigationItem (
//                icon = {
//                    Icon(
//                        ImageVector.vectorResource(id = R.drawable.ic_fav),
//                                contentDescription = "Favorite"
//                    )
//                },
//                selected = false,
//                onClick = {
//
//                }
//            )
//        }
//    }
}