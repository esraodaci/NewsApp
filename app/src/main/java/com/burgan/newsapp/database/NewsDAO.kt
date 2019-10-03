package com.burgan.newsapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDAO {

    @Insert
    fun insertAllNews(list: List<NewsModel>)

    @Query(value = "SELECT * FROM cache ORDER BY id ASC")
    fun getAllNews(): List<NewsModel>

    @Query("DELETE FROM cache")
    fun deleteAllNews()
}