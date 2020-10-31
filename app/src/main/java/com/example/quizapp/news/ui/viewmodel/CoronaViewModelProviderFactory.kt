package com.example.quizapp.news.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.news.data.repository.CoronaRepository

class CoronaViewModelProviderFactory(val coronaRepository:CoronaRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoronaViewModel(coronaRepository) as T
    }
}