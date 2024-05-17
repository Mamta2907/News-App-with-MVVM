package com.mamta.mvvmnewsapp.apiconfig

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //private const val BASE_URL = "https://rndtd.com/demos/wealth-build/api/"
    private const val BASE_URL = "https://newsapi.org/v2/"


    val gson = GsonBuilder().setLenient().create()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}