package com.example.speakfreely.app.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translation_favorite")
data class TranslationFavorite (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sourceText: String,
    val translatedText: String
)