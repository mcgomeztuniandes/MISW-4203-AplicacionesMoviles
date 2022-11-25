package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentAlbumDetailInfoBinding
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel

class AlbumDetailInfoFragment : Fragment() {
    private var binding: FragmentAlbumDetailInfoBinding? = null

    lateinit var viewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it).get(AlbumViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_album_detail_info, container, false)

        val btnInfo: Button = binding!!.btnInfo
        val btnTracks: Button = binding!!.btnTracks
        val btnComments: Button = binding!!.btnComments
        val btnPerformers: Button = binding!!.btnPerformers

        btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_selected_color))

        btnTracks.setOnClickListener {
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, AlbumDetailTracksFragment.newInstance())
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
            val radius = 50

            Glide.with(requireContext())
                .load(data.cover)
                .centerCrop()
                .transform(RoundedCorners(radius))
                .into(binding!!.img)
            binding!!.tvAlbumName.text = data.name
            binding!!.tvDescription.text = data.description
            binding!!.tvGenreRecordLabel.text =  data.genre + " - " + data.recordLabel
            binding!!.tvReleaseDate.text = data.releaseDate.substring(0,10)

       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = AlbumDetailInfoFragment()
    }
}