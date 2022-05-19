package com.far.dictionaryapp.data.util

import com.google.gson.Gson
import java.lang.reflect.Type

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

class GsonParser(private val gson: Gson) : JsonParser {
	
	override fun <T> fromJson(json: String, type: Type): T? {
		return gson.fromJson(json, type)
	}
	
	override fun <T> toJson(obj: T, type: Type): String? {
		return gson.toJson(obj, type)
	}
}