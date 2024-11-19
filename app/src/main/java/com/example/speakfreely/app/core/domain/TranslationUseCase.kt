package com.example.speakfreely.app.core.domain

import jakarta.inject.Inject
import com.example.speakfreely.app.core.TranslationApi
import com.example.speakfreely.app.core.TranslationResponse

// Взаимодействие с бизнес-логикой
class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    // sl - source lang, dl - destination lang
    suspend fun translate(sl: LanguageCode, dl: LanguageCode, text: String): TranslationResponse {
        return translationApi.translate(sl.code, dl.code, text)
    }
}