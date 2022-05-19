package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.Phonetic

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class PhoneticDto(
	val audio: String,
	val license: LicenseDto,
	val sourceUrl: String,
	val text: String
) {
	fun toPhonetic() = Phonetic(
		audio = audio,
		license = license.toLicense(),
		sourceUrl = sourceUrl,
		text = text
	)
}