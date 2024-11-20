package com.example.speakfreely.app.core.domain.history

import com.example.speakfreely.app.core.data.TranslationHistory
import com.example.speakfreely.app.core.data.TranslationHistoryDao
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
) {
    suspend fun save(sourceText: String, translatedText: String) {
        translationHistoryDao.insertHistory(
            TranslationHistory(
                sourceText = sourceText,
                translatedText = translatedText
            )
        )
    }
}