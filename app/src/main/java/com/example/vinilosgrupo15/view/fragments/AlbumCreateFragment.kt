package com.example.vinilosgrupo15.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.databinding.FragmentAlbumCreateBinding
import com.example.vinilosgrupo15.model.AlbumDTO
import com.example.vinilosgrupo15.viewmodels.AlbumViewModel

class AlbumCreateFragment : Fragment() {
    lateinit var viewAlbumModel: AlbumViewModel
    private var _binding: FragmentAlbumCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewAlbumModel =
            activity?.let {
                ViewModelProvider(it).get(AlbumViewModel::class.java)
            }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumCreateBinding.inflate(inflater,container,false)
        binding.viewModel = viewAlbumModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       setupButton()

    }

    private fun setupButton(){
        binding.saveAlbum.setOnClickListener{ submitAlbum() }
    }

    private fun submitAlbum(){
        println("Submit")
        var validForm: Boolean = true
        var required: String = "Required field"
        val inputName = binding.editTextAlbumName.text.toString()
        val inputCover = binding.editTextAlbumCover.text.toString()
        val inputReleaseDate = binding.editTextAlbumReleaseDate.text.toString()
        val inputGenre = binding.genreList.selectedItem.toString()
        val inputLabel = binding.recordList.selectedItem.toString()
        val inputDescription = binding.editTextAlbumDescription.text.toString()

        if (inputName.isBlank()){
            binding.editTextAlbumName.error = required
            validForm = false
        }

        if (inputCover.isBlank()){
            binding.editTextAlbumCover.error = required
            validForm = false
        }

        if (inputReleaseDate.isBlank()){
            binding.editTextAlbumReleaseDate.error = required
            validForm = false
        }

        if (inputGenre.equals("Select genre")){
            Toast.makeText(this@AlbumCreateFragment.requireActivity(),"Genre is required", Toast.LENGTH_SHORT).show()
            validForm = false
        }

        if (inputLabel.equals("Select record label")){
            Toast.makeText(this@AlbumCreateFragment.requireActivity(),"Record label is required", Toast.LENGTH_SHORT).show()
            validForm = false
        }

        if (inputDescription.length<10){
            binding.editTextAlbumDescription.error = "Min length >= 10"
            validForm = false
        }

        println(validForm)
        if(validForm) {
            val albumInfo = AlbumDTO(
                name = inputName,
                cover = inputCover,
                releaseDate = inputReleaseDate,
                description = inputDescription,
                genre = inputGenre,
                recordLabel = inputLabel
            )

            viewAlbumModel.fetchCreateAlbum(albumInfo)
            Toast.makeText(this@AlbumCreateFragment.requireActivity(),"Album created successful", Toast.LENGTH_SHORT).show()
            //Redirect to albums list
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container,AlbumListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()

        }
    }

}