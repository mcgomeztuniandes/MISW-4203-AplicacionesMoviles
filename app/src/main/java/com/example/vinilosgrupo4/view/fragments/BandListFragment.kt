package com.example.vinilosgrupo4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo4.R
import com.example.vinilosgrupo4.databinding.FragmentBandListBinding
import com.example.vinilosgrupo4.model.BandReponseDataModel
import com.example.vinilosgrupo4.view.adapter.itemsBandAdapter
import com.example.vinilosgrupo4.viewmodels.BandViewModel

class BandListFragment : Fragment(), ClickBandListener {
    lateinit var viewBandModel: BandViewModel
    lateinit var binding: FragmentBandListBinding
    private var myBandAdapter: itemsBandAdapter?= null

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
        binding.viewModel = viewBandModel

        var btnBands: Button = binding.btnBandas

        btnBands.setOnClickListener {

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myBandAdapter = itemsBandAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = myBandAdapter

        viewBandModel.listBands.observe(viewLifecycleOwner) {
            myBandAdapter?.setItems(list = it)
            binding.progress.isInvisible = true
        }

        viewBandModel.progressBands.observe(viewLifecycleOwner) {
            binding.progress.isInvisible = true
        }

        viewBandModel.fetchBandData()
    }

    override fun itemSelect(data: BandReponseDataModel) {
        viewBandModel.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, BandDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}

interface ClickBandListener {
    fun itemSelect(data: BandReponseDataModel)
}
