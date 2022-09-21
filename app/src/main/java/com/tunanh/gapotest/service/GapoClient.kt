package com.tunanh.gapotest.service

import com.tunanh.gapotest.model.ItemPost
import retrofit2.http.GET

interface GapoClient {
    @GET("feed")
    suspend fun getAllPost():List<ItemPost>
}