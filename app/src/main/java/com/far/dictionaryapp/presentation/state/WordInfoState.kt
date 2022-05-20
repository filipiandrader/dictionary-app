package com.far.dictionaryapp.presentation.state

import com.far.dictionaryapp.domain.model.WordInfo

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class WordInfoState(
	val wordInfoItems: List<WordInfo> = emptyList(),
	val errorMessage: String = "",
	val isLoading: Boolean = false
)
