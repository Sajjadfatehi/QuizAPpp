package com.example.quizapp.news.data.remote

import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.news.data.modelfromservice.SpecificCountry
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoronaApi {

    @GET("all")
    suspend fun getAllInformation():Response<AllInformation>

    @GET("countries")
    suspend fun getAllCountry():Response<AllCountry>

    @GET("countries/")
    suspend fun specificCountry(
        @Query("query")
        query:String
    ):Response<SpecificCountry>

}