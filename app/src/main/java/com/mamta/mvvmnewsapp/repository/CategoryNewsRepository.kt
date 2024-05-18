package com.mamta.mvvmnewsapp.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mamta.mvvmnewsapp.apiconfig.RetrofitInstance
import com.mamta.mvvmnewsapp.model.Articles
import com.mamta.mvvmnewsapp.model.CategoryNewsResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryNewsRepository {


    //private val healthNewsLiveData = MutableLiveData<List<Articles>>()
    private val errorLiveData = MutableLiveData<String>()

    fun getHealthNews(): MutableLiveData<List<Articles>> {

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise(
            "in",
            "health",
            "49f2e42c782147fca18fab3c4c9f6693"
        ).enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                call: Call<CategoryNewsResponseData?>,
                response: Response<CategoryNewsResponseData?>
            ) {

                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()!!.articles
                    Log.d("Api Response", "list: $data.toString()")
                } else {
                    //Toast.makeText(this@CategoryNewsRepository,"Response not success",Toast.LENGTH_SHORT).show()
                    errorLiveData.value = "Response not successful"
                    Log.d("Api Response", "response not success")
                }

            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
                Log.d("Api Response", "response error: ${p1.message}")
            }
        })
        return data

    }

    fun getSportNews(): MutableLiveData<List<Articles>>{

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise(
            "in",
            "sport",
            "49f2e42c782147fca18fab3c4c9f6693"
        ).enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                p0: Call<CategoryNewsResponseData?>,
                p1: Response<CategoryNewsResponseData?>
            ) {
                if (p1.isSuccessful && p1.body() != null) {
                    data.value = p1.body()!!.articles
                    Log.d("Api Response", "list: $data.toString()")
                } else {
                    //Toast.makeText(this@CategoryNewsRepository,"Response not success",Toast.LENGTH_SHORT).show()
                    errorLiveData.value = "Response not successful"
                    Log.d("Api Response", "response not success")
                }
            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
                Log.d("Api Response", "response error: ${p1.message}")
            }
        })
        return data
    }


    fun getTechnologyData():MutableLiveData<List<Articles>>{

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise("in","technology","49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                p0: Call<CategoryNewsResponseData?>,
                p1: Response<CategoryNewsResponseData?>
            ) {
                if(p1.isSuccessful){

                    data.value = p1.body()!!.articles

                }
                else{
                    errorLiveData.value = "Response Not Success"
                }

            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
            }
        })

        return data
    }

    fun getBusinessData():MutableLiveData<List<Articles>>{

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise("in","business","49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                p0: Call<CategoryNewsResponseData?>,
                p1: Response<CategoryNewsResponseData?>
            ) {
                if(p1.isSuccessful){

                    data.value = p1.body()!!.articles

                }
                else{
                    errorLiveData.value = "Response Not Success"
                }

            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
            }
        })

        return data
    }


    fun getEntertainment():MutableLiveData<List<Articles>>{

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise("in","entertainment","49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                p0: Call<CategoryNewsResponseData?>,
                p1: Response<CategoryNewsResponseData?>
            ) {
                if(p1.isSuccessful){

                    data.value = p1.body()!!.articles

                }
                else{
                    errorLiveData.value = "Response Not Success"
                }

            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
            }
        })

        return data
    }


    fun getScience():MutableLiveData<List<Articles>>{

        val data = MutableLiveData<List<Articles>>()

        RetrofitInstance.apiInterface.newsCategoryWise("in","science","49f2e42c782147fca18fab3c4c9f6693").enqueue(object : Callback<CategoryNewsResponseData?> {
            override fun onResponse(
                p0: Call<CategoryNewsResponseData?>,
                p1: Response<CategoryNewsResponseData?>
            ) {
                if(p1.isSuccessful){

                    data.value = p1.body()!!.articles

                }
                else{
                    errorLiveData.value = "Response Not Success"
                }

            }

            override fun onFailure(p0: Call<CategoryNewsResponseData?>, p1: Throwable) {
                errorLiveData.value = p1.message
            }
        })

        return data
    }


    fun getErrorLiveData(): MutableLiveData<String> {
        return errorLiveData
    }

}