package com.burgan.newsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.burgan.newsapp.R
import com.burgan.newsapp.models.NewsViewModel
import com.burgan.newsapp.network.AdapterList
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Stetho.initializeWithDefaults(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        NewsViewModel(application).getNewsAsync(this, onSuccess = { articles ->
            val adapter = AdapterList(articles, this)
            recyclerView.adapter = adapter
        })

    }



}
