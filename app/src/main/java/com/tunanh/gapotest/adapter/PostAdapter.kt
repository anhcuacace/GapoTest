package com.tunanh.gapotest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tunanh.gapotest.databinding.ItemEndBinding
import com.tunanh.gapotest.databinding.ItemFirstBinding
import com.tunanh.gapotest.databinding.PostBinding
import com.tunanh.gapotest.model.ItemPost

class PostAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolderFirst(v:ItemFirstBinding):RecyclerView.ViewHolder(v.root)
    inner class ViewHolderEnd(v:ItemEndBinding):RecyclerView.ViewHolder(v.root)
    inner class ViewHolderPost(private val v:PostBinding):RecyclerView.ViewHolder(v.root){
        fun bind(itemPost:ItemPost){
            val adapter=ItemPostAdapter(itemPost)
            v.rclV.adapter=adapter
        }
    }
    val postList:List<ItemPost>?=null
    override fun getItemViewType(position: Int): Int {
        return when(position){
            0-> 0
            postList?.size?.plus(1) -> 1
            else -> 2
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val v = ItemFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderFirst(v)
            }
            1 -> {
                val v = ItemEndBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderEnd(v)
            }
            else -> {
                val v = PostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderPost(v)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position != 0 && position != (postList?.size?.plus(1) ?: 1)){
            postList?.let { (holder as ViewHolderPost).bind(it[position]) }
        }
    }

    override fun getItemCount(): Int = postList?.size!! +2
}