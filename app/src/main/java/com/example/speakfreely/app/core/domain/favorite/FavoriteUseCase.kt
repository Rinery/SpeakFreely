package com.example.speakfreely.app.core.domain.favorite

import com.example.speakfreely.app.core.data.TranslationFavorite
import com.example.speakfreely.app.core.data.TranslationFavoriteDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FavoriteUseCase @Inject constructor(
    private val translationFavoriteDao: TranslationFavoriteDao
){
    fun getFavorites() = translationFavoriteDao.getFavorites()

    suspend fun saveFavorite(translationFavorite: TranslationFavorite) {
        translationFavoriteDao.insertFavorite(translationFavorite)
    }
}