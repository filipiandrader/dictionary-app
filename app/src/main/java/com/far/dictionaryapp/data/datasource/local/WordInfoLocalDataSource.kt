package com.far.dictionaryapp.data.datasource.local

import com.far.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface WordInfoLocalDataSource {
	
	suspend fun insert(infos: List<WordInfo>)
	suspend fun delete(words: List<String>)
	suspend fun getWordInfos(word: String):List<WordInfo>
}