package com.example.quizapp.news.data.repository

import com.example.quizapp.news.data.local.CoronaLocalDataSource
import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.news.data.remote.CoronaRemoteDataSource
import com.example.quizapp.util.MyApp
import com.example.quizapp.util.Network
import com.example.quizapp.util.Resource
import javax.inject.Inject

class CoronaRepository @Inject constructor(
    private val localDataSource: CoronaLocalDataSource,
    private val remoteDataSource: CoronaRemoteDataSource
) {

    suspend fun getAllInformation(): Resource<AllInformation> {
        if (Network.hasActiveInternetConnection(MyApp.app)) {
            val result = remoteDataSource.getAllInformation()
            if (result is Resource.Success) {
                result.data?.let { localDataSource.insertInformation(it) }

                return result
            }
            return Resource.Error(result.message.orEmpty())
        } else {
            return Resource.Success(localDataSource.getInformation())
        }
    }

    suspend fun getAllCountry(): Resource<List<AllCountryItem>> {

        if (Network.hasActiveInternetConnection(MyApp.app)) {
            val result = remoteDataSource.getAllCountry()
            if (result is Resource.Success) {
                result.data?.map { allCountryItem ->
                    allCountryItem.mapToCountryItem()
                }?.let { localDataSource.coronaDao.insertAllArticleCountry(it) }
                return Resource.Success(localDataSource.getAllCountryItem())
            }
            return Resource.Error(result.message.orEmpty())
        } else {
            return Resource.Success(localDataSource.getAllCountryItem())
        }

    }


}