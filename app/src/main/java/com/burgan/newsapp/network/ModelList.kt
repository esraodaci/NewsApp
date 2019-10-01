package com.burgan.newsapp.network

data class NewsResponse(
    val articles: List<Article>,
    val sortBy: String,
    val source: String,
    val status: String
)

data class Article(
    val author: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)

