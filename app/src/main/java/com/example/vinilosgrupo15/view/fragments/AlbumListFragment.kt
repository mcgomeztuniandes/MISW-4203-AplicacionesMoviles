package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentAlbumListBinding
import com.example.vinilosgrupo15.model.AlbumResponseDataModel
import com.example.vinilosgrupo15.view.adapter.ItemsAlbumAdapter
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AlbumListFragment: Fragment(), ClickAlbumListener {
    lateinit var viewAlbumModel: AlbumViewModel
    lateinit var binding: FragmentAlbumListBinding
    private var myAlbumAdapter: ItemsAlbumAdapter?= null

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
        var btnCreateAlbum: FloatingActionButton = binding!!.btnCreate

        btnCreateAlbum.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, AlbumCreateFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAlbumAdapter = ItemsAlbumAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = myAlbumAdapter

        viewAlbumModel.listAlbums.observe(viewLifecycleOwner) {
            myAlbumAdapter?.setItems(list = it)
            binding.progress.isVisible = false
        }

        viewAlbumModel.progressAlbums.observe(viewLifecycleOwner) {
            binding.progress.isVisible = true
        }

        viewAlbumModel.fetchAlbumData()
    }

    override fun itemSelect(data: AlbumResponseDataModel) {
        viewAlbumModel.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, AlbumDetailInfoFragment())
            ?.addToBackStack(null)
            ?.commit()

    }
    companion object {
        fun newInstance() = AlbumListFragment()
    }
}

interface ClickAlbumListener {
    fun itemSelect(data: AlbumResponseDataModel)
}