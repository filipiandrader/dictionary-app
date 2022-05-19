package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.Definition

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class DefinitionDto(
	val antonyms: List<String>,
	val definition: String,
	val example: String?,
	val synonyms: List<String>
) {
	fun toDefinition() = Definition(
		antonyms = antonyms,
		definition = definition,
		example = example,
		synonyms = synonyms
	)
}