package com.far.dictionaryapp.data.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.far.dictionaryapp.data.util.JsonParser
import com.far.dictionaryapp.domain.model.Definition
import com.far.dictionaryapp.domain.model.License
import com.far.dictionaryapp.domain.model.Meaning
import com.far.dictionaryapp.domain.model.Phonetic
import com.google.gson.reflect.TypeToken

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@ProvidedTypeConverter
class DataConverter(private val jsonParser: JsonParser) {
	
	@TypeConverter
	fun fromLicenseJson(json: String): License {
		return jsonParser.fromJson<License>(
			json, object : TypeToken<License>() {}.type
		) ?: License("", "")
	}
	
	@TypeConverter
	fun toLicenseJson(license: License): String {
		return jsonParser.toJson(
			license, object : TypeToken<License>() {}.type
		) ?: "{}"
	}
	
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
	
	@TypeConverter
	fun fromPhoneticsJson(json: String): List<Phonetic> {
		return jsonParser.fromJson<ArrayList<Phonetic>>(
			json, object : TypeToken<ArrayList<Phonetic>>() {}.type
		) ?: emptyList()
	}
	
	@TypeConverter
	fun toPhoneticsJson(phonetics: List<Phonetic>): String {
		return jsonParser.toJson(
			phonetics, object : TypeToken<ArrayList<Phonetic>>() {}.type
		) ?: "[]"
	}
	
	@TypeConverter
	fun fromStringListJson(json: String): List<String> {
		return jsonParser.fromJson<ArrayList<String>>(
			json, object : TypeToken<ArrayList<String>>() {}.type
		) ?: emptyList()
	}
	
	@TypeConverter
	fun toStringListJson(stringList: List<String>): String {
		return jsonParser.toJson(
			stringList, object : TypeToken<ArrayList<String>>() {}.type
		) ?: "[]"
	}
	
	@TypeConverter
	fun fromDefinitionsJson(json: String): List<Definition> {
		return jsonParser.fromJson<ArrayList<Definition>>(
			json, object : TypeToken<ArrayList<Definition>>() {}.type
		) ?: emptyList()
	}
	
	@TypeConverter
	fun toDefinitionsJson(definitions: List<Definition>): String {
		return jsonParser.toJson(
			definitions, object : TypeToken<ArrayList<Definition>>() {}.type
		) ?: "[]"
	}
}