package com.example.speakfreely.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun TextInput(language: String, text: String, onTextChange: (String) -> Unit, onClearText: () -> Unit, modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(text = language)
        OutlinedTextField(value = text, onValueChange = onTextChange, modifier = Modifier.fillMaxWidth(), placeholder =  { Text("Enter text here...") }, trailingIcon = {
            IconButton(onClick = onClearText) {
                Icon(Icons.Default.Clear, contentDescription = "Clear text")
            }
        })
    }
}

@Composable
fun TranslateButton(onTranslate: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = onTranslate,
            modifier = Modifier
                .align(Alignment.CenterEnd) // Выравнивание кнопки к правой стороне
                .padding(top = 8.dp)
        ) {
            Text("Translate")
        }
    }
}

@Composable
fun TranslationResult(
    result: String,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit // добавляем обработчик клика на иконку
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween // выравниваем элементы
    ) {
        OutlinedTextField(
            value = result,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.weight(1f) // текстовое поле занимает основное пространство
        )
        IconButton(onClick = onFavoriteClick) { // иконка справа
            Icon(Icons.Default.Star, contentDescription = "Add to Favorites")
        }
    }
}

@Composable
fun LanguageSelector(
    sourceLanguage: String,
    targetLanguage: String,
    modifier: Modifier = Modifier,
    onSwapLanguages: () -> Unit
) {
    // TODO: Добавить кнопку смены языков
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Text("Source: $sourceLanguage")
        Button(onClick = onSwapLanguages) { Text("Swap") }
        Text("Target: $targetLanguage")
    }
}