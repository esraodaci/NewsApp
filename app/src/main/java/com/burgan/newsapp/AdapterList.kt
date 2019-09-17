package com.burgan.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_news.view.*

class AdapterList( private val news: List<Article>, private val context: Context) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = news[position].title
        holder.txtDetail.text = news[position].description
        Glide.with(context).load(news[position].urlToImage).into(holder.imViewNews)

        holder.recyclerViewRow.setOnClickListener {
            val intent = Intent(context,ListDetailActivity::class.java)
            intent.putExtra("txtTitle",news[position].title)
            intent.putExtra("txtDetail",news[position].description)
            intent.putExtra("imViewNews",news[position].urlToImage)
            context.startActivity(intent)
        }
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val txtTitle: TextView= view.txtTitle
        val txtDetail: TextView = view.txtDetail
        val imViewNews: ImageView = view.imViewNews
        val recyclerViewRow: FrameLayout = view.recyclerViewRow

    }

}


