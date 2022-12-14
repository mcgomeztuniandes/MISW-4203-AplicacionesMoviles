package com.example.vinilosgrupo15.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.MusicianRowBinding
import com.example.vinilosgrupo15.model.MusiciansResponseDataModel
import com.example.vinilosgrupo15.view.fragments.ClickMusicianListener
import com.example.vinilosgrupo15.view.viewholder.ItemMusicianViewHolder

class ItemsMusicianAdapter(private var listener: ClickMusicianListener): RecyclerView.Adapter<ItemMusicianViewHolder>() {
    private val resource = R.layout.musician_row
    lateinit var context: Context

    private val itemList = mutableListOf<MusiciansResponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMusicianViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: MusicianRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemMusicianViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemMusicianViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<MusiciansResponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}