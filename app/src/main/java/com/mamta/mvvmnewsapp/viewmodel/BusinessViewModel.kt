package com.mamta.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.repository.CategoryNewsRepository

class BusinessViewModel : ViewModel() {

    private val categoryNewsRepository = CategoryNewsRepository()
    private val businessLivedata = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()

    fun getBusinessData() {
        categoryNewsRepository.getBusinessData().observeForever {
            businessLivedata.value = it
        }

        categoryNewsRepository.getErrorLiveData().observeForever {
            errorLiveData.value = it
        }
    }


    fun observerBusinessLiveData(): MutableLiveData<List<Articles>> {
        return businessLivedata
    }

    fun errorLiveData(): MutableLiveData<String> {
        return errorLiveData
    }
}