package com.example.vinilosgrupo15.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.BandRowBinding
import com.example.vinilosgrupo15.model.BandReponseDataModel
import com.example.vinilosgrupo15.view.fragments.ClickBandListener
import com.example.vinilosgrupo15.view.viewholder.ItemBandViewHolder

class ItemsBandAdapter(private var listener: ClickBandListener): RecyclerView.Adapter<ItemBandViewHolder>() {
    private val resource = R.layout.band_row
    lateinit var context: Context

    private val itemList = mutableListOf<BandReponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBandViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: BandRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemBandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemBandViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<BandReponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}