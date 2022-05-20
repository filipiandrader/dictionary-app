package com.far.dictionaryapp.data.remote.datasource

import com.far.dictionaryapp.data.datasource.remote.WordInfoDataSource
import com.far.dictionaryapp.data.remote.service.DictionaryService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class WordInfoDataSourceImpl @Inject constructor(private val service: DictionaryService) : WordInfoDataSource {
	
	override fun getWordInfo(word: String) = flow {
		emit(service.getWordInfo(word).map { it.toWordInfo() })
	}
}