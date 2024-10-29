package com.example.wefitbinding.api

import com.example.wefitbinding.api.model.MoviesAPIResult
import retrofit2.Call
import retrofit2.http.GET

interface WeFItService {

    @GET("movies")
    fun listMovies(): Call<MoviesAPIResult>

}