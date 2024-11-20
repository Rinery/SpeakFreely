package com.example.speakfreely.app.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.speakfreely.app.core.data.TranslationFavorite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val favorites = viewModel.getFavorites().collectAsState(initial = emptyList())

    Column {
        TopAppBar(title = { Text("Favorite")})

        LazyColumn {
            items(favorites.value) { favorite ->
                Text("Source: ${favorite.sourceText}")
                Text("Translation: ${favorite.translatedText}")
            }
        }
    }
}