package com.example.quizapp.news.ui

import com.example.quizapp.news.data.modelfromservice.AllCountryItem

interface ClickListener {

    fun onCardClick( allCountryItem:AllCountryItem)
}