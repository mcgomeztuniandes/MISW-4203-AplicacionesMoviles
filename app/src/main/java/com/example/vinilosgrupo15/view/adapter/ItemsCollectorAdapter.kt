package com.example.vinilosgrupo15.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.CollectorRowBinding
import com.example.vinilosgrupo15.model.CollectorsResponseDataModel
import com.example.vinilosgrupo15.view.viewholder.ItemCollectorViewHolder

class ItemsCollectorAdapter(): RecyclerView.Adapter<ItemCollectorViewHolder>() {
    private val resource = R.layout.collector_row
    lateinit var context: Context

    private val itemList = mutableListOf<CollectorsResponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCollectorViewHolder {
        context = parent.context

        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var binding: CollectorRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemCollectorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemCollectorViewHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    fun setItems(list: MutableList<CollectorsResponseDataModel>){
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}