package com.burgan.newsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.burgan.newsapp.models.NewsViewModel
import com.burgan.newsapp.network.AdapterList
import com.facebook.stetho.Stetho
import com.burgan.newsapp.R
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        Stetho.initializeWithDefaults(this)


        //Adapter
        val adapter = AdapterList(this)
        recyclerView.adapter = adapter
        //RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //ProgressBar
        incProgressBar.visibility = View.VISIBLE

        NewsViewModel(application).getNewsAsync(this,
            onSuccess = { articles ->
                adapter.setItems(articles)
                incProgressBar.visibility = View.GONE
            },
            onCache = { articles  ->
                adapter.setItems(articles)
                incProgressBar.visibility = View.GONE
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_update -> {
                NewsViewModel(application).deleteCache(this)
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
