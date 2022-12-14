package com.example.vinilosgrupo15.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.vinilosgrupo15.model.AlbumDTO
import com.example.vinilosgrupo15.model.AlbumResponseDataModel
import com.example.vinilosgrupo15.model.CommentDTO
import com.example.vinilosgrupo15.repository.AlbumRepository
import com.example.vinilosgrupo15.repository.CommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext

class AlbumViewModel (app: Application): AndroidViewModel(app), CoroutineScope {
    private val _itemSelected = MutableLiveData<AlbumResponseDataModel>()
    var itemDataSelected: AlbumResponseDataModel? = null

    private val _listAlbums = MutableLiveData<ArrayList<AlbumResponseDataModel>>()
    var listAlbums: LiveData<ArrayList<AlbumResponseDataModel>> = _listAlbums

    private val _progressAlbums = MutableLiveData<Boolean>()
    var progressAlbums: LiveData<Boolean> = _progressAlbums

    private val repository = AlbumRepository()
    private val repositoryComment = CommentRepository()

    var observerOnCategorySelected: Observer<AlbumResponseDataModel> = Observer { value ->
        value.let {
            _itemSelected.value = it
        }
    }

    private val viewModelJob = Job()

    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    fun clearSelection() {
        _itemSelected.value = null
    }

    fun setItemSelection(item: AlbumResponseDataModel) {
        itemDataSelected = item
    }

    fun fetchAlbumData() {
        _progressAlbums.value = true
        viewModelScope.launch {
            val response = repository.getAllAlbums()

            response?.body()?.let { list ->
                _listAlbums.value = list
            }
        }
    }

    fun fetchCreateCommentData(id_album:Long, commentDTO: CommentDTO) {
        viewModelScope.launch {
            val response = repositoryComment.addComment(id_album, commentDTO)
        }
    }

    fun fetchCreateAlbum(newAlbum:AlbumDTO){
        viewModelScope.launch {
            val response = repository.createNewAlbum(newAlbum)
            response?.body()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}