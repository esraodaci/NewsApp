package com.burgan.newsapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_list_detail.*
import kotlinx.android.synthetic.main.content_list_detail.txtDetail

class ListDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)
        setSupportActionBar(toolbar)

        title = intent.getStringExtra("txtTitle")
        txtDetail.text = intent.getStringExtra("txtDetail")
        Glide.with(this).load(intent.getStringExtra("imViewNews")).into(imViewNews)



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        detailBackButton.setOnClickListener {
            finish()
        }
    }

}

