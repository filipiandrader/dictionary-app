package com.far.dictionaryapp.data.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.far.dictionaryapp.data.util.JsonParser
import com.far.dictionaryapp.domain.model.Meaning
import com.google.gson.reflect.TypeToken

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@ProvidedTypeConverter
class DataConverter(private val jsonParser: JsonParser) {
	
	@TypeConverter
	fun fromMeaningsJson(json: String): List<Meaning> {
		return jsonParser.fromJson<ArrayList<Meaning>>(
			json, object : TypeToken<ArrayList<Meaning>>() {}.type
		) ?: emptyList()
	}
	
	@TypeConverter
	fun toMeaningsJson(meanings: List<Meaning>): String {
		return jsonParser.toJson(
			meanings, object : TypeToken<ArrayList<Meaning>>() {}.type
		) ?: "[]"
	}
}