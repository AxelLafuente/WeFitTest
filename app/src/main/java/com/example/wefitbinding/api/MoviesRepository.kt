package com.example.wefitbinding.api

import com.example.wefitbinding.api.model.MoviesAPIResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesRepository {
    private val service: WeFItService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://wefit-movies.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(WeFItService::class.java)
    }

    fun getMovies() : MoviesAPIResult? {
        val call = service.listMovies()

        return call.execute().body()
//        call.enqueue(object: Callback<MoviesAPIResult>{
//            override fun onResponse(
//                call: Call<MoviesAPIResult>,
//                response: Response<MoviesAPIResult>
//            ) {
//                if (response.isSuccessful){
//                    val body = response.body()
//
//                    body?.results?.let {
//
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<MoviesAPIResult>, t: Throwable) {
//                TODO("Not yet implemented")
//            }

    }
}