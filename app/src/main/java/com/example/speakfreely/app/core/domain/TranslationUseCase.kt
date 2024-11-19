package com.example.speakfreely.app.core.domain

import jakarta.inject.Inject
import com.example.speakfreely.app.core.TranslationApi

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    suspend fun translate() {

    }
}