package com.burgan.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_news.view.*

class AdapterList( private val news: List<Article>, private val context: Context) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtDetail.text = news[position].description
        holder.txtTitle.text = news[position].title


    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val txtDetail: TextView = view.txtDetail
        val txtTitle: TextView= view.txtTitle
        val imViewNews: ImageView = view.imViewNews
    }

}


