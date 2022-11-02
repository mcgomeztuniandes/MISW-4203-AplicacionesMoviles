package com.example.vinilosgrupo4.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.MusicianRowBinding
import com.example.vinilosgrupo4.model.MusiciansResponseDataModel
import com.example.vinilosgrupo4.view.fragments.ClickMusicianListener
import com.example.vinilosgrupo4.view.viewholder.itemMusicianViewHolder

class itemsMusicianAdapter(private var listener: ClickMusicianListener): RecyclerView.Adapter<itemMusicianViewHolder>() {
    private val resource = R.layout.musician_row
    lateinit var context: Context

    private val itemList = mutableListOf<MusiciansResponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemMusicianViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: MusicianRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return itemMusicianViewHolder(binding)
    }


    override fun onBindViewHolder(holder: itemMusicianViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<MusiciansResponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}