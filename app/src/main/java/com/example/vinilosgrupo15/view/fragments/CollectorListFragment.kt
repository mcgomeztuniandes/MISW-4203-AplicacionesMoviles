package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentCollectorListBinding
import com.example.vinilosgrupo15.model.CollectorsResponseDataModel
import com.example.vinilosgrupo15.view.adapter.ItemsCollectorAdapter
import com.example.vinilosgrupo15.viewmodels.CollectorViewModel


class CollectorListFragment : Fragment(), ClickCollectorListener {
    lateinit var viewCollectorModel : CollectorViewModel
    lateinit var binding: FragmentCollectorListBinding
    private var myCollectorAdapter: ItemsCollectorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewCollectorModel =
            activity?.let {
                ViewModelProvider(it).get(CollectorViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collector_list, container, false)
        binding.viewModel = viewCollectorModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myCollectorAdapter = ItemsCollectorAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = myCollectorAdapter

        viewCollectorModel.listCollectors.observe(viewLifecycleOwner){
            myCollectorAdapter?.setItems(list = it)
            binding.progress.isVisible = false
        }

        viewCollectorModel.progressCollectors.observe(viewLifecycleOwner){
            binding.progress.isVisible = true
        }

        viewCollectorModel.fetchCollectorData()

    }


    companion object {
        fun newInstance() = CollectorListFragment()

    }

    override fun itemSelect(data: CollectorsResponseDataModel) {
        viewCollectorModel.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, CollectorDetailFragment())
            ?.addToBackStack(null)
            ?.commit()

    }
}

interface ClickCollectorListener {
    fun itemSelect(data: CollectorsResponseDataModel)
}