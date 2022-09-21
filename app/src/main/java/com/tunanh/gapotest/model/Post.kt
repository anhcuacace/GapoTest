package com.tunanh.gapotest.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("data")
    val data: List<Data>? = null
)
data class Data()
