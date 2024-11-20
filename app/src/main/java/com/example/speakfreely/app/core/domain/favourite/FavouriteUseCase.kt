package com.example.speakfreely.app.core.domain.favourite

import com.example.speakfreely.app.core.data.TranslationFavorite
import com.example.speakfreely.app.core.data.TranslationFavoriteDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FavouriteUseCase @Inject constructor(
    private val translationFavoriteDao: TranslationFavoriteDao
){
    fun getFavourites(): Flow<List<TranslationFavorite>> = translationFavoriteDao.getFavorites()
}