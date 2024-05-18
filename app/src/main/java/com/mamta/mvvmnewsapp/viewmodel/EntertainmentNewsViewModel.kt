package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository

class EntertainmentNewsViewModel:ViewModel() {

    private val categoryNewsRepository = CategoryNewsRepository()
    private val entertainmentLiveData = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()

    fun getBusinessData() {
        categoryNewsRepository.getEntertainment().observeForever {
            entertainmentLiveData.value = it
        }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }
    }


    fun observerEntertainmentLiveData(): MutableLiveData<List<Articles>> {
        return entertainmentLiveData
    }

    fun errorLiveData(): MutableLiveData<String> {
        return errorLiveData
    }
}