package com.example.wefitbinding

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Visibility
import com.example.wefitbinding.api.domain.MoviesMap
import com.example.wefitbinding.databinding.ActivityMainBinding
import com.example.wefitbinding.view.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment(), getString(R.string.home_fragment_title_text), 0)

        binding.bottomNavigationView.selectedItemId = R.id.home

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment(), getString(R.string.home_fragment_title_text),0)
                R.id.cart -> replaceFragment(ShoppingCartFragment(), getString(R.string.shopping_fragment_title_text), 8)
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment, title : String?, subTitle: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

        binding.subTitleText.visibility = subTitle

        title.let {
            binding.titleFragmentText.text = title
        }
        if (title == getString(R.string.shopping_fragment_title_text)){
            binding.finishOrderLayout.visibility = VISIBLE
        }else{
            binding.finishOrderLayout.visibility = GONE

        }



    }

}