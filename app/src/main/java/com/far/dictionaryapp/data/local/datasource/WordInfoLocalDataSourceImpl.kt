package com.far.dictionaryapp.data.local.datasource

import com.far.dictionaryapp.data.datasource.local.WordInfoLocalDataSource
import com.far.dictionaryapp.data.local.dao.WordInfoDao
import com.far.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.flow

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class WordInfoLocalDataSourceImpl(private val wordInfoDao: WordInfoDao) : WordInfoLocalDataSource {
	
	override fun insert(infos: List<WordInfo>) = flow {
		emit(wordInfoDao.insert(infos.map { it.toWordInfoEntity() }))
	}
	
	override fun delete(words: List<String>) = flow {
		emit(wordInfoDao.delete(words))
	}
	
	override fun getWordInfos(word: String) = flow {
		emit(wordInfoDao.getWordInfos(word).map { it.toWordInfo() })
	}
}