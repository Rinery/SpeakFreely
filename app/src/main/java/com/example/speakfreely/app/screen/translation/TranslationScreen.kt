package com.example.speakfreely.app.screen.translation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.speakfreely.app.core.domain.availableLanguages
import com.example.speakfreely.app.ui.LanguageSelector
import com.example.speakfreely.app.ui.TextInput
import com.example.speakfreely.app.ui.TranslateButton
import com.example.speakfreely.app.ui.TranslationResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslationScreen(
    viewModel: TranslationViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(title = { Text("Translation App") })

        // Обновленный компонент выбора языков
        LanguageSelector(
            sourceLanguage = uiState.value.sourceLang,
            targetLanguage = uiState.value.targetLang,
            availableLanguages = availableLanguages,
            onSourceLanguageSelected = { code, name ->
                viewModel.updateSourceLanguage(code, name)
            },
            onTargetLanguageSelected = { code, name ->
                viewModel.updateTargetLanguage(code, name)
            },
            onSwapLanguages = { viewModel.swapLanguages() }
        )


        Spacer(modifier = Modifier.height(16.dp))

        TextInput(
            language = uiState.value.sourceLang,
            text = uiState.value.inputText,
            onTextChange = { viewModel.updateInputText(it) },
            onClearText = { viewModel.clearInputText() },
            modifier = Modifier.padding(horizontal = 16.dp), // добавлен горизонтальный отступ
        )

        Spacer(modifier = Modifier.height(16.dp))

        TranslateButton(
            onTranslate =  { viewModel.translateText() },
            isEnabled = uiState.value.inputText.isNotBlank(), // кнопка перевода неактивна если в ней нет текста
            modifier = Modifier.padding(horizontal = 16.dp), // добавлен горизонтальный отступ
        )

        Spacer(modifier = Modifier.height(16.dp))

        uiState.value.translatedText?.let { translatedText ->
            TranslationResult(
                result = translatedText,
                modifier = Modifier.padding(horizontal = 16.dp), // добавлен горизонтальный отступ
                onFavoriteClick = { viewModel.saveToFavorites() }
            )
        }
    }
}