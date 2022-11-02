package com.example.vinilosgrupo4.viewmodels

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.vinilosgrupo4.model.MusiciansResponseDataModel
import com.example.vinilosgrupo4.repository.MusicianRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.CoroutineContext

class MusicianViewModel(app: Application): AndroidViewModel(app), CoroutineScope {
    private val _itemSelected = MutableLiveData<MusiciansResponseDataModel>()
    var itemDataSelected: MusiciansResponseDataModel? = null

    private val _listMusicians = MutableLiveData<ArrayList<MusiciansResponseDataModel>>()
    var listMusicians: LiveData<ArrayList<MusiciansResponseDataModel>> = _listMusicians

    private val _progressMusicians = MutableLiveData<Boolean>()
    var progressMusicians: LiveData<Boolean> = _progressMusicians

    private val repository = MusicianRepository()

    lateinit var observerOnCategorySelected: Observer<MusiciansResponseDataModel>

    private val viewModelJob = Job()

    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    init {
        observerOnCategorySelected = Observer { value ->
            value.let {
                _itemSelected.value = it
            }
        }
    }

    fun clearSelection() {
        _itemSelected.value = null
    }

    fun setItemSelection(item: MusiciansResponseDataModel) {
        itemDataSelected = item
    }

    fun fetchMusicianData() {
        _progressMusicians.value = true
        viewModelScope.launch {
            val response = repository.getAllMusicians()

            response?.body()?.let { list ->
                _listMusicians.value = list
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}