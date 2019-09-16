package com.burgan.newsapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val newsApi = retrofit.create(ApiInterface::class.java)

        newsApi.getAllNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                recyclerView.adapter = AdapterList(response.body()!!.articles, this@ListActivity)
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "response", Toast.LENGTH_LONG).show()
            }
        })

    }


}
