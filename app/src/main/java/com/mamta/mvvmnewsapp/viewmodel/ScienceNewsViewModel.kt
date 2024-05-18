package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository

class ScienceNewsViewModel : ViewModel() {

    private val categoryNewsRepository = CategoryNewsRepository()
    private val scienceLiveData = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()

    fun getScienceNews(){

        categoryNewsRepository.getScience().observeForever {
            scienceLiveData.value = it
        }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }

    }


    fun observeScienceLiveData():MutableLiveData<List<Articles>>{
        return scienceLiveData
    }

    fun observeErrorLiveData():MutableLiveData<String>{
        return errorLiveData
    }

}