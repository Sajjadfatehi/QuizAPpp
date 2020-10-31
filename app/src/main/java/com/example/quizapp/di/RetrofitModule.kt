package com.example.quizapp.di

import com.example.quizapp.util.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder() = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Singleton
    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor) =
        OkHttpClient.Builder().addNetworkInterceptor(object :
            Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {

                return chain.proceed(request = chain.request())
            }
        }).addInterceptor { chain ->
            var newBuilder = chain.request().newBuilder()

            val request = newBuilder.build()
            chain.proceed(request)
        }.addNetworkInterceptor(logging)
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(provideOkHttpClient(provideLoggingInterceptor()))
        .build()

}