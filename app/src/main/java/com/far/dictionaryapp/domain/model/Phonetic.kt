package com.far.dictionaryapp.domain.model

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class Phonetic(
	val audio: String,
	val license: License,
	val sourceUrl: String,
	val text: String
)
