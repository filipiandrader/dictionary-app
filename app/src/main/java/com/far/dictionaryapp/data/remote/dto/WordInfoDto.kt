package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.License
import com.far.dictionaryapp.domain.model.WordInfo

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class WordInfoDto(
	val license: LicenseDto? = null,
	val meanings: List<MeaningDto>? = null,
	val origin: String? = null,
	val phonetic: String? = null,
	val phonetics: List<PhoneticDto>? = null,
	val sourceUrls: List<String>? = null,
	val word: String? = null
) {
	fun toWordInfo() = WordInfo(
		license = license?.toLicense() ?: License("",""),
		meanings = meanings?.map { it.toMeaning() }.orEmpty(),
		origin = origin,
		phonetic = phonetic.orEmpty(),
		phonetics = phonetics?.map { it.toPhonetic() }.orEmpty(),
		sourceUrls = sourceUrls.orEmpty(),
		word = word.orEmpty()
	)
}