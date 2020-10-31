package com.example.quizapp.news.data.modelfromservice

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class AllCountryItem(
    var active: Int?,
    var activePerOneMillion: Double?,
    var cases: Int?,
    var casesPerOneMillion: Double?,
    var continent: String?,
    @PrimaryKey var country: String,
    @Ignore var countryInfo: CountryInfo?,
    var critical: Int?,
    var criticalPerOneMillion: Double?,
    var deaths: Int?,
    var deathsPerOneMillion: Double?,
    var oneCasePerPeople: Double?,
    var oneDeathPerPeople: Double?,
    var oneTestPerPeople: Double?,
    var population: Double?,
    var recovered: Int?,
    var recoveredPerOneMillion: Double?,
    var tests: Int?,
    var testsPerOneMillion: Double?,
    var todayCases: Int?,
    var todayDeaths: Int?,
    var todayRecovered: Int?,
    var updated: Long,
    var flag: String,
    var iso2: String,
    var iso3: String,
    var lat: Double,
    @SerializedName("long")
    var longtitud: Double
) : Parcelable{

    fun mapToCountryItem():AllCountryItem{
       return AllCountryItem(active=active,activePerOneMillion = activePerOneMillion,cases = cases,
        casesPerOneMillion = casesPerOneMillion,continent = continent,country = country,
           countryInfo = countryInfo,critical = critical,
        criticalPerOneMillion = criticalPerOneMillion,deaths = deaths,deathsPerOneMillion = deathsPerOneMillion,
        oneCasePerPeople = oneCasePerPeople,oneDeathPerPeople = oneDeathPerPeople,oneTestPerPeople = oneTestPerPeople,
        population = population,recovered = recovered,recoveredPerOneMillion = recoveredPerOneMillion,
        tests = tests,testsPerOneMillion = testsPerOneMillion,todayCases = todayCases,
        todayDeaths = todayDeaths,todayRecovered = todayRecovered,updated = updated,flag = flag,
        iso2 = iso2,iso3 = iso3,lat = lat,longtitud =longtitud)
    }

    constructor():this(
        active=0,
        activePerOneMillion = 0.0,
        cases = 0,
        casesPerOneMillion = 0.0,
        continent = "",
        country = "",
        countryInfo = null,
        critical = 0,
        criticalPerOneMillion = 0.0,
        deaths = 0,
        deathsPerOneMillion = 0.0,
        oneCasePerPeople = 0.0,
        oneDeathPerPeople = 0.0,
        oneTestPerPeople=0.0,
        population = 0.0,
        recovered = 0,
        recoveredPerOneMillion = 0.0,
        tests = 0,
        testsPerOneMillion = 0.0,
        todayCases = 0,
        todayDeaths = 0,
        todayRecovered = 0,
        updated = 0,
        flag = "",
        iso2 = "",
        iso3 = "",
        lat = 0.0,
        longtitud = 0.0

    )


}