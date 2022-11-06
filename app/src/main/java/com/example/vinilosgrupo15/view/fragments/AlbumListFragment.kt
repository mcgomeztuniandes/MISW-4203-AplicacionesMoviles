package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentAlbumListBinding
import com.example.vinilosgrupo15.view.adapter.ItemsAlbumAdapter
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel


class AlbumListFragment: Fragment() {
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAlbumAdapter = ItemsAlbumAdapter()
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

    companion object {
        fun newInstance() = AlbumListFragment()
    }

}