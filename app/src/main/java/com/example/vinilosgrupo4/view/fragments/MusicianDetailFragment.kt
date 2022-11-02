package com.example.vinilosgrupo4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.FragmentMusicianDetailBinding
import com.example.vinilosgrupo4.viewmodels.MusicianViewModel

class MusicianDetailFragment : Fragment() {
    private var _binding: FragmentMusicianDetailBinding? = null
    private val binding get() = _binding

    lateinit var viewModel: MusicianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it).get(MusicianViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicianDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            Glide.with(requireContext()).load(data.image).into(binding!!.img)
            binding!!.tvName.text = data.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MusicianDetailFragment()
    }
}