package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        var btnPerformers: TextView = binding!!.buttonPerformers

        var btnAlbums: TextView = binding!!.buttonAlbums

        var btnCollectors: TextView = binding!!.buttonCollectors

        btnPerformers.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, MusicianListFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnAlbums.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, AlbumListFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnCollectors.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, CollectorListFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        return binding!!.root
    }
}