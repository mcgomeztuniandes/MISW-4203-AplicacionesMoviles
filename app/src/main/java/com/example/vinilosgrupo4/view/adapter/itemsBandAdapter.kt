package com.example.vinilosgrupo4.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.BandRowBinding
import com.example.vinilosgrupo4.model.BandReponseDataModel
import com.example.vinilosgrupo4.view.fragments.ClickBandListener
import com.example.vinilosgrupo4.view.viewholder.itemBandViewHolder

class itemsBandAdapter(private var listener: ClickBandListener): RecyclerView.Adapter<itemBandViewHolder>() {
    private val resource = R.layout.band_row
    lateinit var context: Context

    private val itemList = mutableListOf<BandReponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemBandViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: BandRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return itemBandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemBandViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<BandReponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}