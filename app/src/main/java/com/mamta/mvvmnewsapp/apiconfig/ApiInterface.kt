package com.mamta.mvvmnewsapp.apiconfig

import com.mamta.mvvmnewsapp.model.NewsApiTopHeadingResponseData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getTopHeading(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsApiTopHeadingResponseData>
}