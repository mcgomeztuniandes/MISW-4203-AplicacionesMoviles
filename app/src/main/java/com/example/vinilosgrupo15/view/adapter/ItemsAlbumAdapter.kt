package com.example.vinilosgrupo15.view.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.AlbumRowBinding
import com.example.vinilosgrupo15.model.AlbumResponseDataModel
import com.example.vinilosgrupo15.view.fragments.ClickAlbumListener
import com.example.vinilosgrupo15.view.viewholder.ItemAlbumViewHolder

class ItemsAlbumAdapter(private val listener: ClickAlbumListener): RecyclerView.Adapter<ItemAlbumViewHolder>() {
    private val resource = R.layout.album_row
    lateinit var context: Context

    private val itemList = mutableListOf<AlbumResponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAlbumViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: AlbumRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemAlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAlbumViewHolder, position: Int) {
        holder.setItem(itemList[position])
        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<AlbumResponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}