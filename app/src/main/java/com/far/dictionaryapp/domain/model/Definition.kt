package com.far.dictionaryapp.domain.model

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class Definition(
	val antonyms: List<String>,
	val definition: String,
	val example: String?,
	val synonyms: List<String>
)
