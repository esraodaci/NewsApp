package com.burgan.newsapp.models

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.burgan.newsapp.database.AppDB
import com.burgan.newsapp.database.NewsModel
import com.burgan.newsapp.network.Article
import com.burgan.newsapp.repository.NewsRepo

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NewsRepo

    // LiveData gives us updated words when they change.
    private val allNews: List<NewsModel>

    init {
        val newsDAO = AppDB.getDatabase(application).NewsDAO()
        repository = NewsRepo(newsdao = newsDAO)
        allNews = repository.allNews
    }


    fun getNewsAsync(context: Context, onSuccess: (resp: List<Article>) -> Unit, onFail: ((t: Throwable) -> Unit)? = null) {
        repository.getNewsAsync(context, onSuccess, onFail)
    }

    fun hash(articles : List<Article>){
        repository.hash(articles)
    }
    fun deleteAllNews(){
        repository.deleteAllNews()
    }

    fun addAllNews(news : List<Article>){
        repository.addNews(news)
    }
}