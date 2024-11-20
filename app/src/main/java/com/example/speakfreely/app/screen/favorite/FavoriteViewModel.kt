package com.example.speakfreely.app.screen.favorite

import androidx.lifecycle.ViewModel
import com.example.speakfreely.app.core.data.TranslationFavorite
import com.example.speakfreely.app.core.domain.favorite.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
): ViewModel() {
    fun getFavorites(): Flow<List<TranslationFavorite>> = favoriteUseCase.getFavorites()
}