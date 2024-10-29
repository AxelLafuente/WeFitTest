package com.example.wefitbinding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wefitbinding.api.MoviesRepository
import com.example.wefitbinding.api.domain.MoviesMap.moviesSingleton
import com.example.wefitbinding.databinding.FragmentHomeBinding
import com.example.wefitbinding.view.MoviesAdapter


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val homeBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view  = homeBinding.root

        val rvMovies = binding!!.rvMovies


        Thread(Runnable {
            loadMovies(rvMovies)
        }).start()
        return view
    }

    private fun loadMovies(rvMovies: RecyclerView) {

        val moviesApiResult = MoviesRepository.getMovies()

        moviesApiResult?.products?.let{
            moviesSingleton = it

            val layoutManager = LinearLayoutManager(context)
            Log.d("jhoelax", it.toString())
            runOnUiThread {
                rvMovies.layoutManager = layoutManager
                rvMovies.adapter = MoviesAdapter(moviesSingleton) }

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}

/*



 */
fun Fragment?.runOnUiThread(action: () -> Unit) {
    this ?: return
    if (!isAdded) return // Fragment not attached to an Activity
    activity?.runOnUiThread(action)
}