package com.far.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.far.dictionaryapp.core.Constants.BASE_URL
import com.far.dictionaryapp.core.Constants.DATABASE_NAME
import com.far.dictionaryapp.data.datasource.local.WordInfoLocalDataSource
import com.far.dictionaryapp.data.datasource.remote.WordInfoDataSource
import com.far.dictionaryapp.data.local.database.DataConverter
import com.far.dictionaryapp.data.local.database.WordInfoDatabase
import com.far.dictionaryapp.data.local.datasource.WordInfoLocalDataSourceImpl
import com.far.dictionaryapp.data.remote.datasource.WordInfoDataSourceImpl
import com.far.dictionaryapp.data.remote.service.DictionaryService
import com.far.dictionaryapp.data.repository.WordInfoRepositoryImpl
import com.far.dictionaryapp.data.util.GsonParser
import com.far.dictionaryapp.domain.repository.WordInfoRepository
import com.far.dictionaryapp.domain.usecase.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/*
 * Created by Filipi Andrade Rocha on 20/05/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {
	
	@Provides
	@Singleton
	fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
		return GetWordInfo(repository)
	}
	
	@Provides
	@Singleton
	fun provideWordInfoRepository(
		remoteDataSource: WordInfoDataSource,
		localDataSource: WordInfoLocalDataSource
	): WordInfoRepository {
		return WordInfoRepositoryImpl(remoteDataSource, localDataSource)
	}
	
	@Provides
	@Singleton
	fun provideWordInfoDataSource(service: DictionaryService): WordInfoDataSource {
		return WordInfoDataSourceImpl(service)
	}
	
	@Provides
	@Singleton
	fun provideWordInfoLocalDataSource(wordInfoDatabase: WordInfoDatabase): WordInfoLocalDataSource {
		return WordInfoLocalDataSourceImpl(wordInfoDatabase.wordInfoDao)
	}
	
	@Provides
	@Singleton
	fun provideWordInfoDatabase(application: Application): WordInfoDatabase {
		return Room.databaseBuilder(
			application, WordInfoDatabase::class.java, DATABASE_NAME
		).addTypeConverter(DataConverter(GsonParser(Gson()))).build()
	}
	
	@Provides
	@Singleton
	fun provideDictionaryService(okHttpClient: OkHttpClient): DictionaryService {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(DictionaryService::class.java)
	}
	
	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient {
		val loggingInterceptor = HttpLoggingInterceptor()
		loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
		
		return OkHttpClient.Builder()
			.addInterceptor(loggingInterceptor)
			.connectTimeout(45, TimeUnit.SECONDS)
			.callTimeout(45, TimeUnit.SECONDS)
			.build()
	}
}