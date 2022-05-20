package com.far.dictionaryapp.domain.usecase

import com.far.dictionaryapp.core.UseCase
import com.far.dictionaryapp.domain.exception.EmptyParamException
import com.far.dictionaryapp.domain.exception.MissingParamsException
import com.far.dictionaryapp.domain.model.WordInfo
import com.far.dictionaryapp.domain.repository.WordInfoRepository
import javax.inject.Inject

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class GetWordInfo @Inject constructor(private val repository: WordInfoRepository) :
	UseCase<List<WordInfo>, GetWordInfo.Params>() {
	
	override fun run(params: Params?) = when {
		params == null -> throw MissingParamsException()
		params.word.isEmpty() -> throw EmptyParamException()
		else -> repository.getWordInfo(params.word)
	}
	
	data class Params(val word: String)
}