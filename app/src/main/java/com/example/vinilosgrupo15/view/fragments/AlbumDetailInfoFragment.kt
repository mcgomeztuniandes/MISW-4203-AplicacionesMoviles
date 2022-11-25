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
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentAlbumDetailInfoBinding
import com.example.vinilosgrupo15.model.CollectorDTO
import com.example.vinilosgrupo15.model.Comment
import com.example.vinilosgrupo15.model.CommentDTO
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel

class AlbumDetailInfoFragment : Fragment() {
    private var binding: FragmentAlbumDetailInfoBinding? = null

    lateinit var viewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            activity?.let {
                ViewModelProvider(it).get(AlbumViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_album_detail_info, container, false)

        val btnInfo: Button = binding!!.btnInfo
        val btnTracks: Button = binding!!.btnTracks
        val btnComments: Button = binding!!.btnComments
        val btnPerformers: Button = binding!!.btnPerformers
        val btnAddComment: Button = binding!!.btnAddComments

        btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_selected_color))

        btnInfo.setOnClickListener {
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_selected_color))
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnTracks.setOnClickListener {
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailTracksFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnComments.setOnClickListener {
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_color))
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailCommentsFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnPerformers.setOnClickListener {
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnPerformers.context,R.color.btn_icon_selected_color))
            btnInfo.setBackgroundColor(ContextCompat.getColor(btnInfo.context,R.color.btn_icon_color))
            btnTracks.setBackgroundColor(ContextCompat.getColor(btnTracks.context,R.color.btn_icon_color))
            btnComments.setBackgroundColor(ContextCompat.getColor(btnComments.context,R.color.btn_icon_color))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentAlbumDetailInfo, AlbumDetailPerformersFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnAddComment.setOnClickListener {
            if(binding!!.etComment.text.toString().length > 0) {
                viewModel.itemDataSelected?.let { data ->
                    val collectorDTO = CollectorDTO(101)
                    val commentDTO = CommentDTO(binding!!.etComment.text.toString(),
                        (1..5).random().toString(),
                        collectorDTO)
                    viewModel.fetchCreateCommentData(data.id, commentDTO)
                    binding!!.etComment.text.clear()
                    val comment = Comment(0, commentDTO.description, commentDTO.rating)
                    viewModel.itemDataSelected?.comments!!.add(comment)
                }
                Toast.makeText(this@AlbumDetailInfoFragment.requireActivity(),
                    "Comment created successful",
                    Toast.LENGTH_SHORT).show()
                btnComments.callOnClick()
            } else {
                Toast.makeText(this@AlbumDetailInfoFragment.requireActivity(),
                    "You must post a comment",
                    Toast.LENGTH_SHORT).show()
            }
        }
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemDataSelected?.let { data ->
            val radius = 50

            Glide.with(requireContext())
                .load(data.cover)
                .centerCrop()
                .transform(RoundedCorners(radius))
                .into(binding!!.img)
            binding!!.tvAlbumName.text = data.name
            binding!!.tvDescription.text = data.description
            binding!!.tvGenreRecordLabel.text =  data.genre + " - " + data.recordLabel
            binding!!.tvReleaseDate.text = data.releaseDate.substring(0,10)
       }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = AlbumDetailInfoFragment()
    }
}