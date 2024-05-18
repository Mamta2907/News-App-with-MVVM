package com.mamta.mvvmnewsapp.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mamta.mvvmnewsapp.apiconfig.RetrofitInstance
import com.mamta.mvvmnewsapp.model.Article
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.model.CategoryNewsResponseData
import com.mamta.mvvmnewsapp.model.NewsApiTopHeadingResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopNewsRepository {

    fun getTopNews(): MutableLiveData<List<Article>> {

        val data = MutableLiveData<List<Article>>()

        RetrofitInstance.apiInterface.getTopHeading(
            "in",
            "49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<NewsApiTopHeadingResponseData?> {
            override fun onResponse(
                call: Call<NewsApiTopHeadingResponseData?>,
                response: Response<NewsApiTopHeadingResponseData?>
            ) {

                if (response.isSuccessful) {
                    data.value = response.body()!!.articles
                } else {

                }
            }

            override fun onFailure(p0: Call<NewsApiTopHeadingResponseData?>, p1: Throwable) {

            }
        })
        return data

    }

}