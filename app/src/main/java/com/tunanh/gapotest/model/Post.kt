package com.tunanh.gapotest.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("data")
    val data: List<Data>? = null,
)

data class Data(
    @SerializedName("content")
    val title: String,
    @SerializedName("content")
    val createTime: Long,
    @SerializedName("post_type")
    val postType: Long,
    @SerializedName("mediaData")
    val mediaData: List<Metadata>,
    val user: User,

)

data class Metadata(
    @SerializedName("src")
    val image: String,
)

data class User(
    @SerializedName("display_name")
    val name: String,
    val avatar: String,
)

