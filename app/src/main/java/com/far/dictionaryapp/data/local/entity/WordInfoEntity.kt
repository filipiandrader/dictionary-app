package com.far.dictionaryapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.far.dictionaryapp.domain.model.License
import com.far.dictionaryapp.domain.model.Meaning
import com.far.dictionaryapp.domain.model.Phonetic
import com.far.dictionaryapp.domain.model.WordInfo

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@Entity
data class WordInfoEntity(
	@PrimaryKey val id: Int? = null,
	val license: License,
	val meanings: List<Meaning>,
	val origin: String,
	val phonetic: String,
	val phonetics: List<Phonetic>,
	val sourceUrls: List<String>,
	val word: String
) {
	fun toWordInfo() = WordInfo(
		license = license,
		meanings = meanings,
		origin = origin,
		phonetic = phonetic,
		phonetics = phonetics,
		sourceUrls = sourceUrls,
		word = word
	)
}
