package com.nxt.testlivedata3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nxt.testlivedata3.Click.Click
import com.nxt.testlivedata3.R
import com.nxt.testlivedata3.model.DataInfo
import kotlinx.android.synthetic.main.item_fragment.view.*

class Adapter(var listData: ArrayList<DataInfo>, var click: Click) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fragment, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        holder.mHeading.text = listData[position].title
        holder.mAuthor.text = listData[position].author
        holder.mTime.text = listData[position].publishedAt
        holder.mContent.text = listData[position].description
        Glide.with(holder.itemView.context)
            .load(listData[position].urlToImage)
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
            click.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mHeading = view.main_heading
        var mContent = view.content
        var mAuthor = view.author
        var mTime = view.time
        var imageView = view.imageview
        var mCardView = view.card_view
    }
}