package com.example.vinilosgrupo15.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.CommentRowBinding
import com.example.vinilosgrupo15.model.Comment
import com.example.vinilosgrupo15.view.viewholder.ItemCommentViewHolder

class ItemsCommentAdapter(): RecyclerView.Adapter<ItemCommentViewHolder>() {
    private val resource = R.layout.comment_row
    lateinit var context: Context

    private val itemList = arrayListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCommentViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: CommentRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemCommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemCommentViewHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    fun setItems(list: ArrayList<Comment>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}