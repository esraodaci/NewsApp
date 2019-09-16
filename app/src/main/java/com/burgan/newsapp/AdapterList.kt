package com.burgan.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterList(val news: List<Article>, val context: Context) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        //holder.itemView.detailDesc.text = news[position].descripsion


    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
}


