package com.burgan.newsapp.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v1/articles?source=bbc-news&sortBy=top&apiKey=4dbc17e007ab436fb66416009dfb59a8")
    fun getAllNews(): Call<NewsResponse>
}