package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.License
import com.far.dictionaryapp.domain.model.Phonetic

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class PhoneticDto(
	val audio: String? = null,
	val license: LicenseDto? = null,
	val sourceUrl: String? = null,
	val text: String? = null
) {
	fun toPhonetic() = Phonetic(
		audio = audio.orEmpty(),
		license = license?.toLicense() ?: License("", ""),
		sourceUrl = sourceUrl.orEmpty(),
		text = text.orEmpty()
	)
}