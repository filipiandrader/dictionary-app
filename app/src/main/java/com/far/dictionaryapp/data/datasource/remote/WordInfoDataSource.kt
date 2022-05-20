package com.far.dictionaryapp.data.datasource.remote

import com.far.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface WordInfoDataSource {
	
	fun getWordInfo(word: String): Flow<List<WordInfo>>
}