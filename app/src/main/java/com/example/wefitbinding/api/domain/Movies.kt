package com.example.wefitbinding.api.domain

data class Movies(
    val image: String,
    val title: String,
    val price: Double,
    val id: Int,
    var amount: Int = 0
)