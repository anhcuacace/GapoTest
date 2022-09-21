package com.tunanh.gapotest.service

import com.tunanh.gapotest.model.Post
import retrofit2.http.GET

interface GapoClient {
    @GET("feed")
    suspend fun getAllPost():List<Post>
}