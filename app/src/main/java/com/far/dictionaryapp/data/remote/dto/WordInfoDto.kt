package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.WordInfo

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class WordInfoDto(
	val license: LicenseDto,
	val meanings: List<MeaningDto>,
	val origin: String,
	val phonetic: String,
	val phonetics: List<PhoneticDto>,
	val sourceUrls: List<String>,
	val word: String
) {
	fun toWordInfo() = WordInfo(
		license = license.toLicense(),
		meanings = meanings.map { it.toMeaning() },
		origin = origin,
		phonetic = phonetic,
		phonetics = phonetics.map { it.toPhonetic() },
		sourceUrls = sourceUrls,
		word = word
	)
}