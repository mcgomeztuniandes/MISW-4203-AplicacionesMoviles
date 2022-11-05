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
import com.example.vinilosgrupo15.databinding.FragmentBandListBinding
import com.example.vinilosgrupo15.view.adapter.ItemsBandAdapter
import com.example.vinilosgrupo15.viewmodels.BandViewModel

class BandListFragment : Fragment() {
    private var viewBandModel: BandViewModel? = null
    private var binding: FragmentBandListBinding? = null
    private var myBandAdapter: ItemsBandAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBandModel =
            activity?.let {
                ViewModelProvider(it).get(BandViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_band_list, container, false)
        binding!!.viewModel = viewBandModel

        var btnbtnMusicians: Button = binding!!.btnMusician

        btnbtnMusicians.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(android.R.id.content, MusicianListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()

            binding!!.recyclerview.isVisible = false
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myBandAdapter = ItemsBandAdapter()
        binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerview.adapter = myBandAdapter

        viewBandModel!!.listBands.observe(viewLifecycleOwner) {
            myBandAdapter?.setItems(list = it)
            binding!!.progress.isInvisible = true
        }

        viewBandModel!!.progressBands.observe(viewLifecycleOwner) {
            binding!!.progress.isInvisible = true
        }

        viewBandModel!!.fetchBandData()
    }

    companion object {
        fun newInstance() = BandListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        myBandAdapter = null
        binding = null
        viewBandModel = null
    }
}
