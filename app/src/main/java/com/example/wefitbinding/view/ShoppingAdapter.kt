package com.example.wefitbinding.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wefitbinding.api.domain.Movies
import com.example.wefitbinding.api.domain.MoviesMap.map
import com.example.wefitbinding.api.domain.MoviesMap.moviesSingleton
import com.example.wefitbinding.api.domain.MoviesMap.totalShoppingList
import com.example.wefitbinding.databinding.ShoppingCartItemBinding

class ShoppingAdapter
    : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ShoppingCartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        var counter = 0
        for (item in map){
            if (item>0){
                counter++
            }
        }
        Log.d("jhoelaxCOunter", counter.toString())
        return counter
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = map[position]
            if (item > 0) {
                Log.d("jhoelaxCounterTest", item.toString())
                moviesSingleton.sortedBy { it.id }
                holder.bindVIew(moviesSingleton.get(position-1))
            }
    }


    class ViewHolder(val binding: ShoppingCartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindVIew(item: Movies) {
            Log.d("jhoelaxViewHolderr", "chegou")

            val shoppingImg = binding.shoppingListMovieImg
            val shoppingTitle = binding.shoppingListMovieTitleTxt
            val shoppingDeleteBtn = binding.shoppingListMovieDeleteBtn
            val shoppingAddBtn = binding.shoppingListMovieAddAmountBtn
            val shoppingRemoveBtn = binding.shoppingListMovieRemoveAmountBtn
            val shoppingAmountTxt = binding.shoppingListMovieAmountTxt
            val shoppingDateTxt = binding.shoppingListMovieAddedDateTxt
            val shoppingItemPriceTxt = binding.shoppingListMoviePriceTxt

            Glide.with(binding.root.context).load(item.image).into(shoppingImg)
            shoppingTitle.text= item.title
            shoppingItemPriceTxt.text = "R$ ${item.price.toString()}"
            shoppingAmountTxt.text = map.get(item.id).toString()

            shoppingItemPriceTxt.text = (item.price * map.get(item.id)).toString()
            totalShoppingList += (item.price * map.get(item.id))
            Log.d("jhoetes", totalShoppingList.toString())
        }


    }
}
