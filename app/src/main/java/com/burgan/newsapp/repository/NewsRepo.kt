package com.burgan.newsapp.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.burgan.newsapp.database.NewsDAO
import com.burgan.newsapp.database.NewsModel
import com.burgan.newsapp.network.ApiInterface
import com.burgan.newsapp.network.Article
import com.burgan.newsapp.network.NewsResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest

class NewsRepo(private val newsdao: NewsDAO ) {

    val allNews : LiveData<List<NewsModel>> = newsdao.getAllNews()

    fun addNews(news : List<Article>){
        newsdao.insertAllNews(news.map { NewsModel(null, it.author, it.description, it.publishedAt, it.title, it.url, it.urlToImage ) })
    }

    fun deleteAll(){
        newsdao.deleteAll()
    }


    //Retrofit
    fun getNewsAsync(context:Context, onSuccess: (resp: List<Article>) -> Unit, onFail: ((t: Throwable) -> Unit)? = null) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        val newsApi = retrofit.create(ApiInterface::class.java)
        val newsCall = newsApi.getAllNews()

        newsCall.enqueue(object : Callback<NewsResponse> {

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                val news = response.body()!!.articles

                generateHash(news[0].title)
                onSuccess.invoke(news)
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                if (onFail == null) {
                    Toast.makeText(context,"failed",Toast.LENGTH_LONG).show()
                } else {
                    onFail.invoke(t)
                }
            }

        })

    }


    //Generate hash from article
    fun generateHash(item : String){
        item.md5()
    }

    //MD5 hash
    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }




    //Shared Preferences


}