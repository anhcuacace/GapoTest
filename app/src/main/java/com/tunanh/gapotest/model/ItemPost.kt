package com.tunanh.gapotest.model

data class ItemPost(
    val typePost: Int,
    val isComment: Boolean,
    val avt:String,
    val name: String,
    val time:String,
    val title: String,
    val content:Int,
    val countReaction:Int,
    val countCmt:Long,
    val countShare:Long,
    val comment: List<Comment>?=null
)

data class Comment(
    val avt: String?="",
    val name: String,
    val title: String,
    val photo: String?="",
    val top:Boolean?=false,
    val time: String
)
