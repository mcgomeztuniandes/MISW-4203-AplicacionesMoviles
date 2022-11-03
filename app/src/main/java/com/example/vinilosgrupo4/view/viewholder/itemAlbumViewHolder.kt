package com.example.vinilosgrupo4.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo4.databinding.AlbumRowBinding
import com.example.vinilosgrupo4.model.AlbumResponseDataModel

class itemAlbumViewHolder(binding: AlbumRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: AlbumRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: AlbumResponseDataModel) {
        binding?.let { view ->
            view.name = model.name
            view.genreAndRecordLabel = model.genre + " - " + model.recordLabel
            view.releaseDate = model.releaseDate.substring(0,10)
            view.goToDetail = ">"
        }
    }
}