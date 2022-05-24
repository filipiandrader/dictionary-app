package com.far.dictionaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.far.dictionaryapp.presentation.viewmodel.WordInfoViewModel
import com.far.dictionaryapp.ui.component.WordInfoItem
import com.far.dictionaryapp.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DictionaryAppTheme {
				val viewModel: WordInfoViewModel = hiltViewModel()
				val getWordInfoState = viewModel.getWordInfoState.value
				val scaffoldState = rememberScaffoldState()
				
				LaunchedEffect(key1 = true) {
					if (getWordInfoState.errorMessage.isNotEmpty()) {
						scaffoldState.snackbarHostState.showSnackbar(message = getWordInfoState.errorMessage)
					}
				}
				
				Scaffold(
					scaffoldState = scaffoldState
				) {
					Box(
						modifier = Modifier.background(MaterialTheme.colors.background)
					) {
						Column(
							modifier = Modifier
								.fillMaxSize()
								.padding(16.dp)
						) {
							TextField(
								value = viewModel.searchQueryState.value,
								onValueChange = viewModel::doSearch,
								modifier = Modifier.fillMaxWidth(),
								placeholder = { Text(text = "Type to search...") }
							)
							Spacer(modifier = Modifier.height(16.dp))
							LazyColumn(
								modifier = Modifier
									.fillMaxSize()
							) {
								items(getWordInfoState.wordInfoItems.size) { index ->
									val wordInfo = getWordInfoState.wordInfoItems[index]
									
									if (index > 0) {
										Spacer(modifier = Modifier.height(8.dp))
									}
									
									WordInfoItem(wordInfo = wordInfo)
									
									if (index < getWordInfoState.wordInfoItems.size - 1) {
										Divider()
									}
								}
							}
						}
						
						if (getWordInfoState.isLoading) {
							CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
						}
					}
				}
			}
		}
	}
}