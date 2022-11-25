package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentCollectorDetailBinding

import com.example.vinilosgrupo15.model.Performer
import com.example.vinilosgrupo15.view.adapter.ItemsPerformerAdapter
import com.example.vinilosgrupo15.viewmodels.CollectorViewModel

class CollectorDetailFragment : Fragment() {
    private var binding: FragmentCollectorDetailBinding? = null

    lateinit var viewModel: CollectorViewModel

    private var myFavoritePerformersAdapter: ItemsPerformerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it).get(CollectorViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_collector_detail, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            binding!!.collectorName.text = data.name
            binding!!.collectorTelephone.text = data.telephone
            binding!!.collectorEmail.text =  data.email

            myFavoritePerformersAdapter = ItemsPerformerAdapter()
            binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
            binding!!.recyclerview.adapter = myFavoritePerformersAdapter
            myFavoritePerformersAdapter?.setItems(data.favoritePerformers as ArrayList<Performer>)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = CollectorDetailFragment()
    }
}