package com.far.dictionaryapp.domain.model

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class Meaning(
	val antonyms: List<String>,
	val definitions: List<Definition>,
	val partOfSpeech: String,
	val synonyms: List<String>
)
