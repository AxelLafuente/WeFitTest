package com.example.wefitbinding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wefitbinding.api.domain.MoviesMap
import com.example.wefitbinding.databinding.FragmentShoppingCartBinding
import com.example.wefitbinding.view.ShoppingAdapter

class ShoppingCartFragment : Fragment() {


    private var binding: FragmentShoppingCartBinding? = null
    private val shoppingBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingCartBinding.inflate(inflater,container,false)
        val view  = shoppingBinding.root


        Thread(Runnable {
            loadMovies()
        }).start()


        return view
    }

    private fun loadMovies() {
        val rvShoppingCartMovies = binding!!.rvShoppingCartMovies
        val LayoutManager = LinearLayoutManager(context)
        runOnUiThread {
            rvShoppingCartMovies.layoutManager = LayoutManager
            rvShoppingCartMovies.adapter = ShoppingAdapter()
            binding!!.shoppingListMovieSubTotal.text = String.format("%.2f", MoviesMap.totalShoppingList)
        }

    }

}
