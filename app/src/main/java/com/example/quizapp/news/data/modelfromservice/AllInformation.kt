package com.example.quizapp.news.data.modelfromservice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AllInformation(
    @PrimaryKey(autoGenerate = true) val informationId:Int,
    var active: Int,
    var activePerOneMillion: Double?,
    var affectedCountries: Int?,
    var cases: Int?,
    var casesPerOneMillion: Int?,
    var critical: Int?,
    var criticalPerOneMillion: Double?,
    var deaths: Int?,
    var deathsPerOneMillion: Double?,
    var oneCasePerPeople: Int?,
    var oneDeathPerPeople: Int?,
    var oneTestPerPeople: Int?,
    var population: Long,
    var recovered: Int?,
    var recoveredPerOneMillion: Double?,
    var tests: Int?,
    var testsPerOneMillion: Double?,
    var todayCases: Int?,
    var todayDeaths: Int?,
    var todayRecovered: Int?,
    var updated: Long?
)