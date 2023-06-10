package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ItemMovieBinding

class HomeAdapter(var context: Context, var data: List<MovieData> ):
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    lateinit var binding: ItemMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var curr = data[position]
        holder.binding.apply {
            name.text=curr.Title
            year.text=curr.Year

        }
        Glide.with(context).load(curr.Poster).into(holder.binding.poster)

    }

    class MyViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}