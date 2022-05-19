package com.far.dictionaryapp.data.remote.service

import com.far.dictionaryapp.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface DictionaryService {
	
	@GET("api/v2/entries/en/{word}")
	suspend fun getWordInfo(@Path("word") word: String): List<WordInfoDto>
}