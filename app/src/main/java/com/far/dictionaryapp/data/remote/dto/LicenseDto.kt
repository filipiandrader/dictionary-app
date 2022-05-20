package com.far.dictionaryapp.data.remote.dto

import com.far.dictionaryapp.domain.model.License

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

data class LicenseDto(
	val name: String? = null,
	val url: String? = null
) {
	fun toLicense() = License(
		name = name.orEmpty(),
		url = url.orEmpty()
	)
}