package com.tunanh.gapotest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConfig {
    const val BASE_URL="https://raw.githubusercontent.com/akaizz/gapo/main/"
    private val builder=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
    val retrofit= builder.build()
}