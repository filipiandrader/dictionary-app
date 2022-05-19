package com.far.dictionaryapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.far.dictionaryapp.data.local.dao.WordInfoDao
import com.far.dictionaryapp.data.local.entity.WordInfoEntity

/*
 * Created by Filipi Andrade Rocha on 19/05/2022.
 */

@Database(
	entities = [WordInfoEntity::class], version = 1
)
@TypeConverters(DataConverter::class)
abstract class WordInfoDatabase : RoomDatabase() {
	
	abstract val wordInfoDao: WordInfoDao
}