package com.example.vinilosgrupo4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.databinding.FragmentBandDetailBinding
import com.example.vinilosgrupo15.model.PerformerPrize
import com.example.vinilosgrupo15.view.adapter.ItemPerformerPrizesAdapter
import com.example.vinilosgrupo15.viewmodels.BandViewModel

class BandDetailFragment : Fragment() {
    private var _binding: FragmentBandDetailBinding? = null
    private val binding get() = _binding
    private var myPerformerPrizesAdapter: ItemPerformerPrizesAdapter? = null

    lateinit var viewModel: BandViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it).get(BandViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBandDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            val radius = 50

            Glide.with(requireContext())
                .load(data.image)
                .centerCrop()
                .transform(RoundedCorners(radius))
                .into(binding!!.img)
            binding!!.tvName.text = data.name
            binding!!.tvCreationDate.text = "Creation: " + data.creationDate.substring(0, 10).replace("-","/")
            binding!!.tvDescription.text = data.description

            myPerformerPrizesAdapter = ItemPerformerPrizesAdapter()
            binding!!.recyclerview.layoutManager = LinearLayoutManager(context)
            binding!!.recyclerview.adapter = myPerformerPrizesAdapter
            myPerformerPrizesAdapter?.setItems(data.performerPrizes as ArrayList<PerformerPrize>)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = BandDetailFragment()
    }
}