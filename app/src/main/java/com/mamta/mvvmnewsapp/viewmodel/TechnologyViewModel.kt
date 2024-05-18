package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository

class TechnologyViewModel : ViewModel() {

    private val categoryNewsRepository = CategoryNewsRepository()
    private val technologyViewModel = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()


    fun getTechnologyNews() {
       categoryNewsRepository.getTechnologyData().observeForever {
           technologyViewModel.value = it
       }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }
    }


    fun getObserveTechnologyLiveData():MutableLiveData<List<Articles>>{
        return technologyViewModel
    }

    fun getObserveErrorLiveData():MutableLiveData<String>{
        return errorLiveData
    }

}