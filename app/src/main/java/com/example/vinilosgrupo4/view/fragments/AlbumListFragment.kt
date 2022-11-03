package com.example.vinilosgrupo4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.FragmentAlbumListBinding
import com.example.vinilosgrupo4.model.AlbumResponseDataModel
import com.example.vinilosgrupo4.view.adapter.itemsAlbumAdapter
import com.example.vinilosgrupo4.viewmodels.AlbumViewModel


class AlbumListFragment: Fragment(), ClickAlbumListener {
    lateinit var viewAlbumModel: AlbumViewModel
    lateinit var binding: FragmentAlbumListBinding
    private var myAlbumAdapter: itemsAlbumAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewAlbumModel =
            activity?.let {
                ViewModelProvider(it).get(AlbumViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_list, container, false)
        binding.viewModel = viewAlbumModel


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAlbumAdapter = itemsAlbumAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = myAlbumAdapter

        viewAlbumModel.listAlbums.observe(viewLifecycleOwner) {
            myAlbumAdapter?.setItems(list = it)
            binding.progress.isInvisible = true
        }

        viewAlbumModel.progressAlbums.observe(viewLifecycleOwner) {
            binding.progress.isInvisible = true
        }

        viewAlbumModel.fetchAlbumData()
    }

    override fun itemSelect(data: AlbumResponseDataModel) {
        viewAlbumModel.setItemSelection(data)

        /*
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, AlbumDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()

         */
    }

    companion object {
        fun newInstance() = AlbumListFragment()
    }

}

interface ClickAlbumListener {
    fun itemSelect(data: AlbumResponseDataModel)
}