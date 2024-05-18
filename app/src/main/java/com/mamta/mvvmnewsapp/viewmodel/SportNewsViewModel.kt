package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository

class SportNewsViewModel : ViewModel() {


    private val sportNewsLiveData = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()
    private val categoryNewsRepository = CategoryNewsRepository()


    fun getSportNews(){

        categoryNewsRepository.getSportNews().observeForever {
            sportNewsLiveData.value = it
        }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }

    }


    fun observeSportNewsLiveData():MutableLiveData<List<Articles>>{
        return sportNewsLiveData
    }

    fun observeErrorLiveData():MutableLiveData<String>{
        return errorLiveData
    }
}