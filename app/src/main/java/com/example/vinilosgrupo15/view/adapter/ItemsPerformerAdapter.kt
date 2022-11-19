package com.example.vinilosgrupo15.view.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.PerformerRowBinding
import com.example.vinilosgrupo15.model.Performer
import com.example.vinilosgrupo15.view.viewholder.ItemPerformerViewHolder

class ItemsPerformerAdapter(): RecyclerView.Adapter<ItemPerformerViewHolder>() {
    private val resource = R.layout.performer_row
    lateinit var context: Context

    private val itemList = arrayListOf<Performer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPerformerViewHolder {
        context = parent.context

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: PerformerRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)

        return ItemPerformerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPerformerViewHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    fun setItems(list: ArrayList<Performer>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemChanged(1)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}