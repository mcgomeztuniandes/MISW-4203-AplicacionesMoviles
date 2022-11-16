package com.example.vinilosgrupo15.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinilosgrupo15.databinding.CollectorRowBinding
import com.example.vinilosgrupo15.model.CollectorsResponseDataModel


class ItemCollectorViewHolder(binding: CollectorRowBinding):RecyclerView.ViewHolder(binding.root) {

    private var binding: CollectorRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: CollectorsResponseDataModel){
        binding?.let { view ->
            view.name = model.name
            view.phone = model.telephone
            view.email = model.email
            view.goToDetail = ">"
            //Glide.with(view.root.context).load(model).in
        }
    }

}