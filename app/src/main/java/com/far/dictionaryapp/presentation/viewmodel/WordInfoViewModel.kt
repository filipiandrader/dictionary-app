package com.far.dictionaryapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.far.dictionaryapp.core.Constants.DEFAULT_ERROR
import com.far.dictionaryapp.domain.usecase.GetWordInfo
import com.far.dictionaryapp.presentation.state.WordInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@HiltViewModel
class WordInfoViewModel @Inject constructor(
	private val getWordInfo: GetWordInfo
) : ViewModel() {
	
	private val _searchQueryState = mutableStateOf("")
	val searchQueryState: State<String> = _searchQueryState
	
	private val _getWordInfoState = mutableStateOf(WordInfoState())
	val getWordInfoState: State<WordInfoState> = _getWordInfoState
	
	private var searchJob: Job? = null
	
	fun doSearch(query: String) {
		_searchQueryState.value = query
		searchJob?.cancel()
		searchJob = viewModelScope.launch {
			delay(500L)
			_getWordInfoState.value = WordInfoState(isLoading = true)
			getWordInfo(
				params = GetWordInfo.Params(query),
				onSuccess = { _getWordInfoState.value = WordInfoState(wordInfoItems = it) },
				onError = {
					_getWordInfoState.value =
						WordInfoState(errorMessage = it.message ?: DEFAULT_ERROR)
				}
			)
		}
	}
}