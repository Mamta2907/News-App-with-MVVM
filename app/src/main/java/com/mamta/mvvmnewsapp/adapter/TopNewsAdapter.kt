package com.mamta.mvvmnewsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mamta.mvvmnewsapp.databinding.ItmeNewsHeadlinesBinding
import com.mamta.mvvmnewsapp.model.Article
import com.squareup.picasso.Picasso

class TopNewsAdapter(private var context: Context, private var list: List<Article>):RecyclerView.Adapter<TopNewsAdapter.ViewHolder>() {


   // private var movieList = ArrayList<Result>()
    /*fun setMovieList(movieList : List<Result>){
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }*/


    inner class ViewHolder(private val binding: ItmeNewsHeadlinesBinding) : RecyclerView.ViewHolder(binding.root){

            fun bind(newsData:Article){
                binding.tvNewsHeading.text = newsData.title
                //binding.tvNewsDescription.text = newsData.description
                Picasso.get().load(newsData.urlToImage).into(binding.imgTopNews)
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItmeNewsHeadlinesBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsData:Article = list[position]
        holder.bind(newsData)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}