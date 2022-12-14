package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentMusicianListBinding
import com.example.vinilosgrupo15.model.MusiciansResponseDataModel
import com.example.vinilosgrupo15.view.adapter.ItemsMusicianAdapter
import com.example.vinilosgrupo15.viewmodels.MusicianViewModel

class MusicianListFragment : Fragment(), ClickMusicianListener {
    private var viewMusicianModel: MusicianViewModel? = null
    private var binding: FragmentMusicianListBinding? = null
    private var myMusicianAdapter: ItemsMusicianAdapter? = null

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
        binding!!.viewModel = viewMusicianModel

        val btnBand: Button = binding!!.btnBand
        val btnMusicians: Button = binding!!.btnMusician

        btnMusicians.setBackgroundColor(ContextCompat.getColor(btnMusicians.context,R.color.btn_icon_selected_color))

        btnBand.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, BandListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myMusicianAdapter = ItemsMusicianAdapter(this)
        binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerview.adapter = myMusicianAdapter

        viewMusicianModel!!.listMusicians.observe(viewLifecycleOwner) {
            myMusicianAdapter?.setItems(list = it)
            binding!!.progress.isVisible = false
        }

        viewMusicianModel!!.progressMusicians.observe(viewLifecycleOwner) {
            binding!!.progress.isVisible = true
        }

        viewMusicianModel!!.fetchMusicianData()
    }

    companion object {
        fun newInstance() = MusicianListFragment()
    }

    override fun itemSelect(data: MusiciansResponseDataModel) {
        viewMusicianModel!!.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, MusicianDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}

interface ClickMusicianListener {
    fun itemSelect(data: MusiciansResponseDataModel)
}
