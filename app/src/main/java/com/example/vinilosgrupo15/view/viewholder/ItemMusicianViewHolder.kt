package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.databinding.MusicianRowBinding
import com.example.vinilosgrupo15.model.MusiciansResponseDataModel

class ItemMusicianViewHolder(binding: MusicianRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: MusicianRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: MusiciansResponseDataModel) {
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