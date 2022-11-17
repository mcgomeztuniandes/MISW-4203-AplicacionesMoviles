package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.databinding.TrackRowBinding
import com.example.vinilosgrupo15.model.Track

class ItemTrackViewHolder(binding: TrackRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: TrackRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: Track) {
        binding?.let { view ->
            view.name = model.name
            view.duration = model.duration
        }
    }
}