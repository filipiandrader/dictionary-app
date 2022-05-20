package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.Meaning

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class MeaningDto(
	val antonyms: List<String>? = null,
	val definitions: List<DefinitionDto>? = null,
	val partOfSpeech: String? = null,
	val synonyms: List<String>? = null
) {
	fun toMeaning() = Meaning(
		antonyms = antonyms.orEmpty(),
		definitions = definitions?.map { it.toDefinition() }.orEmpty(),
		partOfSpeech = partOfSpeech.orEmpty(),
		synonyms = synonyms.orEmpty()
	)
}