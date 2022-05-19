package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.Meaning

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class MeaningDto(
	val antonyms: List<String>,
	val definitions: List<DefinitionDto>,
	val partOfSpeech: String,
	val synonyms: List<String>
) {
	fun toMeaning() = Meaning(
		antonyms = antonyms,
		definitions = definitions.map { it.toDefinition() },
		partOfSpeech = partOfSpeech,
		synonyms = synonyms
	)
}