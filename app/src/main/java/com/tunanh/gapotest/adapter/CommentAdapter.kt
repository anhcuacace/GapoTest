package com.tunanh.gapotest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tunanh.gapotest.R
import com.tunanh.gapotest.databinding.ItemCommentBinding
import com.tunanh.gapotest.model.Comment

class CommentAdapter(private val listComment: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {
    inner class MyViewHolder constructor(val v: ItemCommentBinding) :
        RecyclerView.ViewHolder(v.root) {
        fun bind(comment: Comment) {
            Glide.with(itemView).load(comment.avt).error(R.drawable.ic_avatar).into(v.avatarCmt)
            v.tvNameUser.text = comment.name
            v.content.text = comment.title
            Glide.with(itemView).load(comment.photo).error(R.mipmap.ic_launcher)
                .into(v.imageComment)
            v.tvCreatedTime.text = comment.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listComment[position])
        if (position==0){
            holder.v.isTop.visibility=View.VISIBLE
        }
    }

    override fun getItemCount(): Int =listComment.size
}