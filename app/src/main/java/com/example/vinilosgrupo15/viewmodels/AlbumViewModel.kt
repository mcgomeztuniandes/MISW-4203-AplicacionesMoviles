package com.example.vinilosgrupo15.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.vinilosgrupo15.model.AlbumResponseDataModel

import com.example.vinilosgrupo15.repository.AlbumRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext

class AlbumViewModel (app: Application): AndroidViewModel(app), CoroutineScope {
    private val _listAlbums = MutableLiveData<ArrayList<AlbumResponseDataModel>>()
    var listAlbums: LiveData<ArrayList<AlbumResponseDataModel>> = _listAlbums

    private val _progressAlbums = MutableLiveData<Boolean>()
    var progressAlbums: LiveData<Boolean> = _progressAlbums

    private val repository = AlbumRepository()

    private val viewModelJob = Job()

    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    fun fetchAlbumData() {
        _progressAlbums.value = true
        viewModelScope.launch {
            val response = repository.getAllAlbums()

            response?.body()?.let { list ->
                _listAlbums.value = list
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}