package com.far.dictionaryapp.data.util

import java.lang.reflect.Type

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

interface JsonParser {
	
	fun <T> fromJson(json: String, type: Type): T?
	fun <T> toJson(obj: T, type: Type): String?
}