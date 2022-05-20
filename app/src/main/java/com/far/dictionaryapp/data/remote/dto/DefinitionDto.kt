package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.Definition

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class DefinitionDto(
	val antonyms: List<String>? = null,
	val definition: String? = null,
	val example: String? = null,
	val synonyms: List<String>? = null
) {
	fun toDefinition() = Definition(
		antonyms = antonyms.orEmpty(),
		definition = definition.orEmpty(),
		example = example,
		synonyms = synonyms.orEmpty()
	)
}