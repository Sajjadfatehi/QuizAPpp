package com.example.quizapp.di

import android.content.Context
import androidx.room.Room
import com.example.quizapp.db.AppDataBase
import com.example.quizapp.util.Constants.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext, AppDataBase::class.java, DATA_BASE_NAME
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    @Singleton
    @Provides
    fun provideCoronaDao(db:AppDataBase)=db.coronaDao()


}