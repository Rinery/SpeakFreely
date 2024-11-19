package com.example.speakfreely.app.core.domain

import jakarta.inject.Inject
import com.example.speakfreely.app.core.TranslationApi
import com.example.speakfreely.app.core.TranslationResponse

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    // sl - source lang, dl - destination lang
    suspend fun translate(sl: String, dl: String, text: String): TranslationResponse {
        return translationApi.translate(sl, dl, text)
    }
}