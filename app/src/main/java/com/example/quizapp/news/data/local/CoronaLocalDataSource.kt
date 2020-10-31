package com.example.quizapp.news.data.local

import com.example.quizapp.db.AppDataBase
import com.example.quizapp.news.data.modelfromservice.AllInformation
import javax.inject.Inject

class CoronaLocalDataSource @Inject constructor( val coronaDao: CoronaDao) {

    suspend fun insertInformation(allInformation:AllInformation)=
        coronaDao.insertInformation(allInformation)

    suspend fun getInformation()=coronaDao.getInformation()

    suspend fun getAllCountryItem()=coronaDao.getAllCountryItem()
}