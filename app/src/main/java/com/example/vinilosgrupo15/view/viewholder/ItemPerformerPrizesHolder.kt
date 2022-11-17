package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.databinding.PerformerprizesRowBinding
import com.example.vinilosgrupo15.model.PerformerPrize

class ItemPerformerPrizesHolder(binding: PerformerprizesRowBinding): RecyclerView.ViewHolder(binding.root) {
    private var binding: PerformerprizesRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: PerformerPrize) {
        binding?.let { view ->
            view.premiationDate = model.premiationDate.substring(0, 10).replace("-","/")
        }
    }
}