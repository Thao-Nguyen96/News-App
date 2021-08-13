package com.nxt.testlivedata3.api

import android.telecom.Call
import com.nxt.testlivedata3.model.Data
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



//https://newsapi.org/v2/top-headlines?country=us&apiKey=eb4ad6db55664fed859956dd12c3e9df
interface RetroService {

    //lay du lieu tu may chu
    @GET("top-headlines")
    fun getNews(
        @Query("country")country: String,
        @Query("pageSize")pagesize: Int,
        @Query("apiKey")apiKey : String
    ): retrofit2.Call<Data>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country")country: String,
        @Query("category")category: String,
        @Query("pageSize")pagesize: Int,
        @Query("apiKey")apiKey : String
    ):retrofit2.Call<Data>
}