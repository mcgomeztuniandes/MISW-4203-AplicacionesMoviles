package com.example.vinilosgrupo4.repository

import com.example.vinilosgrupo4.servicesadapter.BandService
import com.example.vinilosgrupo4.servicesadapter.RetrofitClient

class BandRepository {
    private var apiService: BandService? = null

    init {
        apiService = RetrofitClient.getClient?.create(BandService::class.java)
    }

    suspend fun getAllBands() = apiService?.getBands()
}