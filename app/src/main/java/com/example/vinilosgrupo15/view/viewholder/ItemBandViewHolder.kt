package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.databinding.BandRowBinding
import com.example.vinilosgrupo15.model.BandReponseDataModel

class ItemBandViewHolder(binding: BandRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: BandRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: BandReponseDataModel) {
        binding?.let { view ->
            view.name = model.name

            val radius = 50

            Glide.with(view.root.context)
                .load(model.image)
                .centerCrop()
                .transform(RoundedCorners(radius))
                .into(binding!!.imgCharacter)
        }
    }
}