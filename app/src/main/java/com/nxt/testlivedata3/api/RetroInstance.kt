package com.nxt.testlivedata3.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        const val API_KEY = "eb4ad6db55664fed859956dd12c3e9df"
        const val BASE_URL = "https://newsapi.org/v2/"
        const val PICTURE_BASE_URL = "https://image.tmdb.org/t/p/w342"

        //url co so
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                    //su dung gson de chuyen phan hoi
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}