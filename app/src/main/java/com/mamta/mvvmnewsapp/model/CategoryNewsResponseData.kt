package com.mamta.mvvmnewsapp.model

import com.google.gson.annotations.SerializedName

data class CategoryNewsResponseData(

    val articles: List<Articles>,
    val status: String,
    val totalResults: Int
)

data class Articles(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Sources,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class Sources(
    val id: String,
    val name: String
)