package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentMusicianListBinding
import com.example.vinilosgrupo15.model.MusiciansResponseDataModel
import com.example.vinilosgrupo15.view.adapter.itemsMusicianAdapter
import com.example.vinilosgrupo15.viewmodels.MusicianViewModel

class MusicianListFragment : Fragment(), ClickMusicianListener {
    lateinit var viewMusicianModel: MusicianViewModel
    lateinit var binding: FragmentMusicianListBinding
    private var myMusicianAdapter: itemsMusicianAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMusicianModel =
            activity?.let {
                ViewModelProvider(it).get(MusicianViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_musician_list, container, false)
        binding.viewModel = viewMusicianModel

        var btnBand: Button = binding.btnBand

        btnBand.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(android.R.id.content, BandListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()

            binding.recyclerview.isVisible = false
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myMusicianAdapter = itemsMusicianAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = myMusicianAdapter

        viewMusicianModel.listMusicians.observe(viewLifecycleOwner) {
            myMusicianAdapter?.setItems(list = it)
            binding.progress.isInvisible = true
        }

        viewMusicianModel.progressMusicians.observe(viewLifecycleOwner) {
            binding.progress.isInvisible = true
        }

        viewMusicianModel.fetchMusicianData()
    }

    override fun itemSelect(data: MusiciansResponseDataModel) {
        viewMusicianModel.setItemSelection(data)

        /*
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, MusicianDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()

         */
    }

    companion object {
        fun newInstance() = MusicianListFragment()
    }
}

interface ClickMusicianListener {
    fun itemSelect(data: MusiciansResponseDataModel)
}
