package com.example.vinilosgrupo15.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.PerformerprizesRowBinding
import com.example.vinilosgrupo15.model.PerformerPrize
import com.example.vinilosgrupo15.view.viewholder.ItemPerformerPrizesHolder

class ItemPerformerPrizesAdapter(): RecyclerView.Adapter<ItemPerformerPrizesHolder>() {
    private val resource = R.layout.performerprizes_row
    lateinit var context: Context

    private val itemList = arrayListOf<PerformerPrize>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPerformerPrizesHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: PerformerprizesRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemPerformerPrizesHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPerformerPrizesHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    fun setItems(list: ArrayList<PerformerPrize>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}