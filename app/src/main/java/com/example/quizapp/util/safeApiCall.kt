package com.example.quizapp.util

import retrofit2.Response

suspend inline fun <T> safeApiCall(responseFunction: suspend () -> Response<T>): Resource<T> {

    try {
        val result = responseFunction.invoke()
        if (result.isSuccessful) {
            result.body()?.let {
                it.let {
                    return Resource.Success(it)
                }
            }
            return Resource.Error(result.message())
        }
        return Resource.Error(result.message())
    } catch (e: Exception) {
        return Resource.Error("خطا  در برقراری ارتباط")
    }
}