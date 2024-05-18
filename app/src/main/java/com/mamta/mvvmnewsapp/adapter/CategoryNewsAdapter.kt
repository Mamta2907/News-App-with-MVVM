package com.mamta.mvvmnewsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mamta.mvvmnewsapp.databinding.ItemCategoryNewsBinding
import com.mamta.mvvmnewsapp.model.Articles
import com.squareup.picasso.Picasso

class CategoryNewsAdapter(val context: Context, val newsList: List<Articles>) :
    RecyclerView.Adapter<CategoryNewsAdapter.ViewHolder>() {


    inner class ViewHolder(private var binding: ItemCategoryNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(newsData:Articles){

                binding.tvNewsHeading.text = newsData.title
                Picasso.get().load(newsData.urlToImage).into(binding.imgTopNews)

            }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryNewsAdapter.ViewHolder {
        val binding = ItemCategoryNewsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsAdapter.ViewHolder, position: Int) {
        var categoryNewsData: Articles = newsList[position]
        holder.bind(categoryNewsData)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}