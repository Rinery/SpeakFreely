package com.example.speakfreely.app.screen.history

import androidx.lifecycle.ViewModel
import com.example.speakfreely.app.core.data.TranslationHistory
import com.example.speakfreely.app.core.data.TranslationHistoryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HistoryViewModel(
    private val translationHistoryDao: TranslationHistoryDao,
): ViewModel() {
    fun getHistory(): Flow<TranslationHistory> {
        return translationHistoryDao.getTranslationHistory()
    }
}