package com.ntg.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: ArrayList<Movie>?) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvMovieName.text = movieList?.get(position)?.name
    }

    override fun getItemCount(): Int = movieList?.size ?: 0

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMovieName:TextView = itemView.findViewById(R.id.tv_movie_name)
    }
}