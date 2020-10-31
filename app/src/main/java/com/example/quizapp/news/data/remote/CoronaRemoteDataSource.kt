package com.example.quizapp.news.data.remote


import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.util.Resource
import com.example.quizapp.util.safeApiCall
import retrofit2.Retrofit
import javax.inject.Inject

class CoronaRemoteDataSource @Inject constructor(retrofit : Retrofit ) {
    private val api= retrofit.create(CoronaApi::class.java)

    suspend fun getAllInformation():Resource<AllInformation>{

        return safeApiCall { api.getAllInformation() }
    }

    suspend fun getAllCountry():Resource<AllCountry>{
        return safeApiCall { api.getAllCountry() }
    }
}