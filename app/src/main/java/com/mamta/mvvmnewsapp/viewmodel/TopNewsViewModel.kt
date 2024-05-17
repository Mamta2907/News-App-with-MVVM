package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.R
import com.mamta.mvvmnewsapp.apiconfig.RetrofitInstance
import com.mamta.mvvmnewsapp.model.Article
import com.mamta.mvvmnewsapp.model.NewsApiTopHeadingResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopNewsViewModel : ViewModel() {

    private var topNewsLiveData = MutableLiveData<List<Article>>()


    fun getTopNews(){
        RetrofitInstance.apiInterface.getTopHeading("in","49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<NewsApiTopHeadingResponseData?> {
            override fun onResponse(
                call: Call<NewsApiTopHeadingResponseData?>,
                response: Response<NewsApiTopHeadingResponseData?>
            ) {
                    if(response.isSuccessful && response.body()!=null){
                        topNewsLiveData.value = response.body()!!.articles
                    }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<NewsApiTopHeadingResponseData?>, t: Throwable) {

            }
        })
    }

    fun observeTopNewsLiveData():LiveData<List<Article>>{
        return topNewsLiveData
    }

}