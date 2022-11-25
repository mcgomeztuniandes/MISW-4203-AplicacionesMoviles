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
import com.example.vinilosgrupo15.databinding.FragmentBandListBinding
import com.example.vinilosgrupo15.model.BandReponseDataModel
import com.example.vinilosgrupo15.view.adapter.ItemsBandAdapter
import com.example.vinilosgrupo15.viewmodels.BandViewModel
import com.example.vinilosgrupo4.view.fragments.BandDetailFragment

class BandListFragment : Fragment(), ClickBandListener  {
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


        val btnMusicians: Button = binding!!.btnMusician
        val btnBand:Button = binding!!.btnBand

        btnBand.setBackgroundColor(ContextCompat.getColor(btnBand.context,R.color.btn_icon_selected_color))

        btnMusicians.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, MusicianListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myBandAdapter = ItemsBandAdapter(this)
        binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerview.adapter = myBandAdapter

        viewBandModel!!.listBands.observe(viewLifecycleOwner) {
            myBandAdapter?.setItems(list = it)
            binding!!.progress.isVisible = false
        }

        viewBandModel!!.progressBands.observe(viewLifecycleOwner) {
            binding!!.progress.isVisible = true
        }

        viewBandModel!!.fetchBandData()
    }

    override fun itemSelect(data: BandReponseDataModel) {
        viewBandModel!!.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, BandDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()

    }

    companion object {
        fun newInstance() = BandListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}

interface ClickBandListener {
    fun itemSelect(data: BandReponseDataModel)
}
