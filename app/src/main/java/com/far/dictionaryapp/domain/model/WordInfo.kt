package com.far.dictionaryapp.domain.model

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class WordInfo(
	val license: License,
	val meanings: List<Meaning>,
	val origin: String,
	val phonetic: String,
	val phonetics: List<Phonetic>,
	val sourceUrls: List<String>,
	val word: String
)
