package com.example.speakfreely.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "translate" // экран при запуске приложения
            ) {
                composable("chat") {}
                composable("camera") {}
                composable("translate") {}
                composable("history") {}
                composable("favourite") {}
            }
        }
    }

    private val Destinations = listOf("chat", "camera", "translate", "history", "favourite")

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        var selectedItem by rememberSaveable { mutableIntStateOf(2) }
        val icons = listOf(
            ImageVector.vectorResource(R.drawable.ic_chat),
            ImageVector.vectorResource(R.drawable.ic_camera),
            ImageVector.vectorResource(R.drawable.ic_translate),
            ImageVector.vectorResource(R.drawable.ic_history),
            ImageVector.vectorResource(R.drawable.ic_fav),
        )

        NavigationBar (
            content = {
                Destinations.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = item
                            )
                        },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index // обновляем выбранную иконку
                            navController.navigate(item) // переходим на другой экран
                        }
                    )
                }
            }
        )

    }

    @Composable
    fun RowScope.BottomNavigationItem(
        selected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        alwaysShowLabel: Boolean = true,
        icon: @Composable () -> Unit,
        selectedIcon: @Composable () -> Unit = icon,
        label: @Composable (() -> Unit)? = null,
    ) {
        NavigationBarItem (
            selected = selected,
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            alwaysShowLabel = alwaysShowLabel,
            icon = if (selected) selectedIcon else icon,
            label = label,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavigationDefaults.navigationSelectedItemColor(), // цвет выбранной иконки
                unselectedIconColor = NavigationDefaults.navigationContentColor(), // цвет невыбранной иконки
                selectedTextColor = NavigationDefaults.navigationSelectedItemColor(), // цвет выбранного текста
                unselectedTextColor = NavigationDefaults.navigationContentColor(), // цвет невыбранного текста
                indicatorColor = NavigationDefaults.navigationIndicatorColor(), // цвет индикатора
            )
        )
    }

    object NavigationDefaults {
        @Composable
        fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

        @Composable
        fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

        @Composable
        fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
    }
}