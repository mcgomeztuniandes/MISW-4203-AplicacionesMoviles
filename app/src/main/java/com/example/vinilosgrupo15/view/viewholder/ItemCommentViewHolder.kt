package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.databinding.CommentRowBinding
import com.example.vinilosgrupo15.model.Comment

class ItemCommentViewHolder(binding: CommentRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: CommentRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: Comment) {
        binding?.let { view ->
            view.rating = "Rating: " + model.rating.toString()
            view.description = model.description
        }
    }
}