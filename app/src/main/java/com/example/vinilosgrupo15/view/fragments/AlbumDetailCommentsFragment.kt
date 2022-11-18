package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel
import com.example.vinilosgrupo15.databinding.FragmentAlbumDetailCommentsBinding
import com.example.vinilosgrupo15.model.Comment
import com.example.vinilosgrupo15.view.adapter.ItemsCommentAdapter


class AlbumDetailCommentsFragment : Fragment() {
    private var _binding: FragmentAlbumDetailCommentsBinding? = null
    private val binding get() = _binding
    private var myPerformerCommentsAdapter: ItemsCommentAdapter? = null
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
        _binding = FragmentAlbumDetailCommentsBinding.inflate(inflater, container, false)
        val btnInfo: Button = binding!!.btnInfo

        btnInfo.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailComments, AlbumDetailInfoFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }
        val btnTracks: Button = binding!!.btnTracks

        btnTracks.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailComments, AlbumDetailTracksFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        val btnPerformers: Button = binding!!.btnPerformers

        btnPerformers.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailComments, AlbumDetailPerformersFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            binding!!.tvAlbumName.text = data.name
            myPerformerCommentsAdapter = ItemsCommentAdapter()
            binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
            binding!!.recyclerview.adapter = myPerformerCommentsAdapter
            myPerformerCommentsAdapter?.setItems(data.comments as ArrayList<Comment>)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = AlbumDetailCommentsFragment()
    }
}
