package com.far.dictionaryapp.domain.repository

import com.far.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface WordInfoRepository {
	
	fun getWordInfo(word: String): Flow<List<WordInfo>>
}