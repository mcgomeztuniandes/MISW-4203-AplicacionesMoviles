package com.example.vinilosgrupo15.viewmodels

import android.app.Application
import androidx.lifecycle.*

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.vinilosgrupo15.model.CollectorsResponseDataModel
import com.example.vinilosgrupo15.repository.CollectorRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CollectorViewModel (app:Application): AndroidViewModel(app), CoroutineScope {

    private val _listCollectors = MutableLiveData<ArrayList<CollectorsResponseDataModel>>()
    var listCollectors: LiveData<ArrayList<CollectorsResponseDataModel>> = _listCollectors

    private val _progressCollectors = MutableLiveData<Boolean>()
    var progressCollectors: LiveData<Boolean> = _progressCollectors

    private val repository = CollectorRepository()

    private val viewModelJob = Job()

    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    fun fetchCollectorData(){
        _progressCollectors.value = true
        viewModelScope.launch{
            val response = repository.getAllCollectors()

            response?.body()?.let { list ->
                _listCollectors.value = list
            }
        }
    }

    override fun onCleared(){
        super.onCleared()
        viewModelJob.cancel()
    }
}