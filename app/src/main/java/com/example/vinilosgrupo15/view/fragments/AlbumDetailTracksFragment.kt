package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel
import com.example.vinilosgrupo15.databinding.FragmentAlbumDetailTracksBinding
import com.example.vinilosgrupo15.model.Track
import com.example.vinilosgrupo15.view.adapter.ItemsTrackAdapter


class AlbumDetailTracksFragment : Fragment() {
    private var _binding: FragmentAlbumDetailTracksBinding? = null
    private val binding get() = _binding
    private var myPerformerTracksAdapter: ItemsTrackAdapter? = null
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
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_detail_tracks, container, false)
        val btnInfo: Button = binding!!.btnInfo
        val btnTracks: Button = binding!!.btnTracks
        val btnComments: Button = binding!!.btnComments
        val btnPerformers: Button = binding!!.btnPerformers

        btnTracks.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_selected_color))

        btnInfo.setOnClickListener {
             btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_selected_color))
             btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
             btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
             btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
             activity?.supportFragmentManager
                 ?.beginTransaction()
                 ?.replace(R.id.container, AlbumDetailInfoFragment.newInstance())
                 ?.addToBackStack(null)
                 ?.commit()
         }

        btnComments.setOnClickListener {
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, AlbumDetailCommentsFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnPerformers.setOnClickListener {
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, AlbumDetailPerformersFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            binding!!.tvAlbumName.text = data.name
            myPerformerTracksAdapter = ItemsTrackAdapter()
            binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
            binding!!.recyclerview.adapter = myPerformerTracksAdapter
            myPerformerTracksAdapter?.setItems(data.tracks as ArrayList<Track>)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = AlbumDetailTracksFragment()
    }
}
