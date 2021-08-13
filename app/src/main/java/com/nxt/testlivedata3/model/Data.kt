package com.nxt.testlivedata3.model

data class Data(val status: String, val totalResults: String, val articles: ArrayList<DataInfo>)
data class DataInfo(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)
