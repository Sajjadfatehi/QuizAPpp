package com.example.quizapp.news.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.news.data.modelfromservice.CountryInfo

@Dao
interface CoronaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInformation( allInformation:AllInformation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticleCountry(allCountryItem: List<AllCountryItem>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleCountry(allCountryItem: AllCountryItem)

    @Query("select * from allinformation")
    suspend fun getInformation():AllInformation

    @Query("select * from allcountryitem")
    suspend fun getAllCountryItem():List<AllCountryItem>
}