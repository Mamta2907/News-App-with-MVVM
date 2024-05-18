package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository
import com.mamta.mvvmnewsapp.repository.TopNewsRepository
import kotlin.Pair

class HealthNewsViewModel : ViewModel() {

    private var healthNewsLiveData = MutableLiveData<List<Articles>>()
    private val categoryNewsRepository = CategoryNewsRepository()
    private val errorLiveData = MutableLiveData<String>()





    //Method to get health news from the repository
    fun getHealthNews(){
        categoryNewsRepository.getHealthNews().observeForever {
            healthNewsLiveData.value = it
        }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }
    }

    fun observeHealthNewsLiveData():MutableLiveData<List<Articles>>{
        return healthNewsLiveData
    }

    fun observeErrorLiveData(): MutableLiveData<String> {
        return errorLiveData
    }



}