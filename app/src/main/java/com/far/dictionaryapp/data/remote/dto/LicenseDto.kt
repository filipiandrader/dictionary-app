package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.License

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class LicenseDto(
	val name: String,
	val url: String
) {
	fun toLicense() = License(
		name = name,
		url = url
	)
}