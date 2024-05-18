package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.apiconfig.RetrofitInstance
import com.mamta.mvvmnewsapp.model.Article
import com.mamta.mvvmnewsapp.model.NewsApiTopHeadingResponseData
import com.mamta.mvvmnewsapp.repository.TopNewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopNewsViewModel : ViewModel() {

    private var topNewsLiveData = MutableLiveData<List<Article>>()
    private var topNewsRepository = TopNewsRepository()



    fun getTopNews(){
        topNewsRepository.getTopNews().observeForever {
            topNewsLiveData.value = it
        }
    }

    fun observeTopNewsLiveData():MutableLiveData<List<Article>>{
        return topNewsLiveData
    }

}