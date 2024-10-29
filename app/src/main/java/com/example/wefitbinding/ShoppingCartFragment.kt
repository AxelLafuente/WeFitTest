package com.example.wefitbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wefitbinding.api.domain.MoviesMap
import com.example.wefitbinding.api.domain.MoviesMap.map
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
            loadSHoppingCart()
        }).start()


        return view
    }

    private fun loadSHoppingCart() {
        val rvShoppingCartMovies = binding!!.rvShoppingCartMovies
        val LayoutManager = LinearLayoutManager(context)
        if(isEmpyShopping()){
        runOnUiThread {
            rvShoppingCartMovies.layoutManager = LayoutManager
            rvShoppingCartMovies.adapter = ShoppingAdapter()
          }

        }
    }}

    private fun isEmpyShopping(): Boolean {
        var count = 0
        for (item in map){
            if (item == 0){
                count++
            }
        }
        if (count== map.size){
            return false
        }else {
            return true
        }
    }
