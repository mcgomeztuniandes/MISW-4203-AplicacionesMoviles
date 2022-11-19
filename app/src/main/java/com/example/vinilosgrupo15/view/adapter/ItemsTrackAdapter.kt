package com.example.vinilosgrupo15.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.TrackRowBinding
import com.example.vinilosgrupo15.model.Track
import com.example.vinilosgrupo15.view.viewholder.ItemTrackViewHolder

class ItemsTrackAdapter(): RecyclerView.Adapter<ItemTrackViewHolder>() {
    private val resource = R.layout.track_row
    lateinit var context: Context

    private val itemList = arrayListOf<Track>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTrackViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: TrackRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemTrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemTrackViewHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    //@SuppressLint("NotifyDataSetChanged")
    fun setItems(list: ArrayList<Track>) {
        itemList.clear()
        itemList.addAll(list)
        //notifyDataSetChanged()
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}