package com.example.quizapp.news.data.modelfromservice

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryInfo(

    var flag: String,
    var iso2: String,
    var iso3: String,
    var lat: Double,
    @SerializedName("long")
    var longtitud: Double
) : Parcelable