package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel
import com.example.vinilosgrupo15.databinding.FragmentAlbumDetailPerformersBinding
import com.example.vinilosgrupo15.model.Performer
import com.example.vinilosgrupo15.view.adapter.ItemsPerformerAdapter


class AlbumDetailPerformersFragment : Fragment() {
    private var _binding: FragmentAlbumDetailPerformersBinding? = null
    private val binding get() = _binding
    private var myPerformerPerformersAdapter: ItemsPerformerAdapter? = null
    lateinit var viewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it)[AlbumViewModel::class.java]
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumDetailPerformersBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            binding!!.tvAlbumName.text = data.name
            myPerformerPerformersAdapter = ItemsPerformerAdapter()
            binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
            binding!!.recyclerview.adapter = myPerformerPerformersAdapter
            myPerformerPerformersAdapter?.setItems(data.performers as ArrayList<Performer>)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = AlbumDetailPerformersFragment()
    }
}
