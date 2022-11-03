package com.example.vinilosgrupo4.view.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.AlbumRowBinding
import com.example.vinilosgrupo4.model.AlbumResponseDataModel
import com.example.vinilosgrupo4.view.fragments.ClickAlbumListener
import com.example.vinilosgrupo4.view.viewholder.itemAlbumViewHolder

class itemsAlbumAdapter(private var listener: ClickAlbumListener): RecyclerView.Adapter<itemAlbumViewHolder>() {
    private val resource = R.layout.album_row
    lateinit var context: Context

    private val itemList = mutableListOf<AlbumResponseDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemAlbumViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: AlbumRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return itemAlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemAlbumViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])
        }
    }

    fun setItems(list: MutableList<AlbumResponseDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}