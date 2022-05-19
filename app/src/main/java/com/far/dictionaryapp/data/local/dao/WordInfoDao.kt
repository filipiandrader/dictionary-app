package com.far.dictionaryapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.far.dictionaryapp.data.local.entity.WordInfoEntity

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@Dao
interface WordInfoDao {
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(infos: List<WordInfoEntity>)
	
	@Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
	suspend fun delete(words: List<String>)
	
	@Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
	suspend fun getWordInfos(word: String): List<WordInfoEntity>
}