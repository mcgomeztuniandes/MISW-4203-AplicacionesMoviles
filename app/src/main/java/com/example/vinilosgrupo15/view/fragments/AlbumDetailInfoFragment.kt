package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        btnInfo.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }
        val btnTracks: Button = binding!!.btnTracks

        btnTracks.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailTracksFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        val btnComments: Button = binding!!.btnComments

        btnComments.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailCommentsFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        val btnPerformers: Button = binding!!.btnPerformers

        btnPerformers.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailPerformersFragment.newInstance())
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

   /* override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }*/

    companion object {
        fun newInstance() = AlbumDetailInfoFragment()
    }
}