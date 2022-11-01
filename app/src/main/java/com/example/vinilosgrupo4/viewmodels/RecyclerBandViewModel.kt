package com.example.vinilosgrupo4.viewmodels
import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.vinilosgrupo4.model.BandReponseDataModel
import com.example.vinilosgrupo4.repository.BandRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.CoroutineContext

class RecyclerBandViewModel(app: Application): AndroidViewModel(app),CoroutineScope {
    private val _itemSelected = MutableLiveData<BandReponseDataModel>()
    var itemDataSelected: BandReponseDataModel? = null

    private val _listBands = MutableLiveData<ArrayList<BandReponseDataModel>>()
    var listBands: LiveData<ArrayList<BandReponseDataModel>> = _listBands

    private val _progressBands = MutableLiveData<Boolean>()
    var progressBands: LiveData<Boolean> = _progressBands

    private val repository = BandRepository()

    lateinit var observerOnCategorySelected: Observer<BandReponseDataModel>

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

    fun setItemSelection(item: BandReponseDataModel) {
        itemDataSelected = item
    }

    fun fetchBandData() {
        _progressBands.value = true
        viewModelScope.launch {
            val response = repository.getAllBands()

            response?.body()?.let { list ->
                _listBands.value = list
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}