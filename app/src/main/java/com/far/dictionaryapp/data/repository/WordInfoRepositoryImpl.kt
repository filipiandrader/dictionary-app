package com.far.dictionaryapp.data.repository

import com.far.dictionaryapp.data.datasource.local.WordInfoLocalDataSource
import com.far.dictionaryapp.data.datasource.remote.WordInfoDataSource
import com.far.dictionaryapp.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class WordInfoRepositoryImpl @Inject constructor(
	private val remoteDataSource: WordInfoDataSource,
	private val localDataSource: WordInfoLocalDataSource
) : WordInfoRepository {
	
	override fun getWordInfo(word: String) = flow {
		val wordInfos = localDataSource.getWordInfos(word)
		
		if (wordInfos.isNotEmpty()) {
			emit(wordInfos)
		} else {
			val remoteWordInfos = remoteDataSource.getWordInfo(word).single()
			localDataSource.delete(remoteWordInfos.map { it.word })
			localDataSource.insert(remoteWordInfos)
			emit(localDataSource.getWordInfos(word))
		}
	}
}