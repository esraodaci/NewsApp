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
    private val allNews: LiveData<List<NewsModel>>

    init {
        val newsDAO = AppDB.getDatabase(application).NewsDAO()
        repository = NewsRepo(newsdao = newsDAO)
        allNews = repository.allNews
    }

    fun insert(news : List<Article>){
        repository.addNews(news)
    }

    fun getNewsAsync(context: Context, onSuccess: (resp: List<Article>) -> Unit, onFail: ((t: Throwable) -> Unit)? = null) {
        repository.getNewsAsync(context, onSuccess, onFail)
    }

    fun deleteAll(){
        repository.deleteAll()
    }

    fun generateHash(){

    }
}