package com.far.dictionaryapp.data.local.datasource

import com.far.dictionaryapp.data.datasource.local.WordInfoLocalDataSource
import com.far.dictionaryapp.data.local.dao.WordInfoDao
import com.far.dictionaryapp.domain.model.WordInfo
import javax.inject.Inject

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class WordInfoLocalDataSourceImpl @Inject constructor(private val wordInfoDao: WordInfoDao) :
	WordInfoLocalDataSource {
	
	override suspend fun insert(infos: List<WordInfo>) =
		wordInfoDao.insert(infos.map { it.toWordInfoEntity() })
	
	override suspend fun delete(words: List<String>) = wordInfoDao.delete(words)
	
	override suspend fun getWordInfos(word: String) =
		wordInfoDao.getWordInfos(word).map { it.toWordInfo() }
}