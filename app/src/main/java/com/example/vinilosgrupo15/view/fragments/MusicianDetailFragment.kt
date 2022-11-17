package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.databinding.FragmentMusicianDetailBinding
import com.example.vinilosgrupo15.model.PerformerPrize
import com.example.vinilosgrupo15.view.adapter.ItemPerformerPrizesAdapter
import com.example.vinilosgrupo15.viewmodels.MusicianViewModel

class MusicianDetailFragment : Fragment() {
    private var _binding: FragmentMusicianDetailBinding? = null
    private val binding get() = _binding
    private var myPerformerPrizesAdapter: ItemPerformerPrizesAdapter? = null

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
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMusicianDetailBinding.inflate(inflater, container, false)
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
            binding!!.tvBirthDate.text = "BirthDate: " + data.birthDate.substring(0, 10).replace("-","/")
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
        fun newInstance() = MusicianDetailFragment()
    }
}