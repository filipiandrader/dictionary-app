package com.far.dictionaryapp.data.datasource.local

import com.far.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface WordInfoLocalDataSource {
	
	fun insert(infos: List<WordInfo>): Flow<Unit>
	fun delete(words: List<String>): Flow<Unit>
	fun getWordInfos(word: String): Flow<List<WordInfo>>
}