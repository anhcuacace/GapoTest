package com.tunanh.gapotest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tunanh.gapotest.R
import com.tunanh.gapotest.databinding.ItemCommentsBinding
import com.tunanh.gapotest.databinding.ItemContentImgBinding
import com.tunanh.gapotest.databinding.ItemPostBinding
import com.tunanh.gapotest.databinding.ItemReactionBinding
import com.tunanh.gapotest.model.Comment
import com.tunanh.gapotest.model.ItemPost

class ItemPostAdapter(private val itemPost: ItemPost) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolderFirst(private val v: ItemPostBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(itemPost: ItemPost) {
            Glide.with(itemView).load(itemPost.avt).error(R.drawable.ic_avatar).into(v.imgUserPost)
            v.tvNameUser.text = itemPost.name
            v.tvCreatedTime.text = itemPost.time
            v.tvTitle.text = itemPost.title
        }
    }

    inner class ViewHolderContent(private val v: ItemContentImgBinding) :
        RecyclerView.ViewHolder(v.root) {
        fun bind(img: Int) {
            Glide.with(itemView).load(img).error(R.mipmap.ic_launcher).into(v.imgTest)
        }
    }

    inner class ViewHolderReaction(private val v: ItemReactionBinding) :
        RecyclerView.ViewHolder(v.root) {
        fun bind(itemPost: ItemPost) {
            v.countReaction.text = itemPost.countReaction.toString()
            v.countCmt.text = itemPost.countCmt.toString()
            v.countShare.text = itemPost.countShare.toString()
        }
    }

    inner class ViewHolderComment(private val v: ItemCommentsBinding) :
        RecyclerView.ViewHolder(v.root) {
        fun bind(listComment: List<Comment>) {
            val adapter = CommentAdapter(listComment)
            v.rclV.adapter = adapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val v = ItemPostBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
                return ViewHolderFirst(v)
            }
            1 -> {
                val v = ItemContentImgBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false)
                return ViewHolderContent(v)
            }
            2 ->{
                val v = ItemReactionBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false)
                return ViewHolderReaction(v)
            }
            else->{
                val v = ItemCommentsBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false)
                return ViewHolderComment(v)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0->{
                (holder as ViewHolderFirst).bind(itemPost)
            }
            1->{
                (holder as ViewHolderContent).bind(itemPost.content)
            }
            2->{
                (holder as ViewHolderReaction).bind(itemPost)
            }
            3->{
                itemPost.comment?.let { (holder as ViewHolderComment).bind(it) }
            }
        }
    }

    override fun getItemCount(): Int {
        return if (itemPost.isComment) {
            4
        } else {
            3
        }
    }
}