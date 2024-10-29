package com.example.wefitbinding.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wefitbinding.api.domain.Movies
import com.example.wefitbinding.api.domain.MoviesMap.map
import com.example.wefitbinding.databinding.HomeMovieCardItemBinding

class MoviesAdapter(
    val items: List<Movies>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeMovieCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindVIew(item, position)
    }


    class ViewHolder(val binding: HomeMovieCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindVIew(item: Movies, position: Int) {
            val movieImage = binding.movieCardImg
            val movieTitle= binding.movieCardTitle
            val moviePrice = binding.movieCardPrice
            val movieButton = binding.movieCardButton

            //TODO: Load image with Glide

            Glide.with(binding.root.context).load(item.image).into(movieImage)
            moviePrice.text = "R$ ${item.price}"
            movieTitle.text = item.title

            movieButton.setOnClickListener {
                map.set(item.id, map[item.id]+1)
                Log.d("jhoelaxButton", map.toString())
            }

        }
    }
}