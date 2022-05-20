package com.far.dictionaryapp.domain.model

import com.far.dictionaryapp.data.local.entity.WordInfoEntity

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
) {
	fun toWordInfoEntity() = WordInfoEntity(
		license = license,
		meanings = meanings,
		origin = origin,
		phonetic = phonetic,
		phonetics = phonetics,
		sourceUrls = sourceUrls,
		word = word
	)
}
