package com.example.quizapp.news.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.news.data.repository.CoronaRepository
import com.example.quizapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CoronaViewModel @ViewModelInject constructor(
    val coronaRepository: CoronaRepository
):ViewModel() {

    val  allInformation:MutableLiveData<Resource<AllInformation>> = MutableLiveData()
    val allCountry:MutableLiveData<Resource<List<AllCountryItem>>> = MutableLiveData()

    init {

        getAllInformation()
        getAllCountry()
    }
    fun getAllInformation()=viewModelScope.launch(Dispatchers.IO){
        val response=coronaRepository.getAllInformation()

        allInformation.postValue(response)

    }


    fun getAllCountry()=viewModelScope.launch(Dispatchers.IO){
        val response=coronaRepository.getAllCountry()
        allCountry.postValue(response)
    }
}