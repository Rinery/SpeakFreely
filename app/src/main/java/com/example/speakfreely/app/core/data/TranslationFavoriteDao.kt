package com.example.speakfreely.app.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TranslationFavoriteDao {
    @Insert
    suspend fun insertFavorite(favorite: TranslationFavorite)

    @Query("SELECT * FROM translation_favorite")
    fun getFavorites(): Flow<List<TranslationFavorite>>
}