package com.example.vinilosgrupo4.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinilosgrupo4.databinding.BandRowBinding
import com.example.vinilosgrupo4.model.BandReponseDataModel

class itemBandViewHolder(binding: BandRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: BandRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: BandReponseDataModel) {
        binding?.let { view ->
            view.name = model.name

            Glide.with(view.root.context).load(model.image).into(view.imgCharacter)
        }
    }
}