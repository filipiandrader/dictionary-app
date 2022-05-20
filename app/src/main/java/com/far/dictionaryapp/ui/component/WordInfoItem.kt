package com.far.dictionaryapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.far.dictionaryapp.domain.model.WordInfo

/*
 * Created by Filipi Andrade Rocha on 20/05/2022.
 */

@Composable
fun WordInfoItem(
	wordInfo: WordInfo,
	modifier: Modifier = Modifier
) {
	Column(modifier = modifier) {
		Text(
			text = wordInfo.word,
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = Color.Black
		)
		Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
		Spacer(modifier = Modifier.height(16.dp))
		wordInfo.origin?.let { origin -> Text(text = origin) }
		
		wordInfo.meanings.forEach { meaning ->
			Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)
			meaning.definitions.forEachIndexed { index, definition ->
				Text(text = "${index + 1}. ${definition.definition}")
				definition.example?.let { example ->
					Spacer(modifier = Modifier.height(8.dp))
					Text(text = "Example: $example")
				}
				Spacer(modifier = Modifier.height(8.dp))
			}
		}
		Spacer(modifier = Modifier.height(8.dp))
	}
}