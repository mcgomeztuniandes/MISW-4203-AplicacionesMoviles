package com.example.vinilosgrupo15.repository

import com.example.vinilosgrupo15.servicesadapter.CollectorService
import com.example.vinilosgrupo15.servicesadapter.RetrofitClient

class CollectorRepository {
    private var apiService: CollectorService? = null

    init {
        apiService = RetrofitClient.getClient?.create(CollectorService::class.java)
    }

    suspend fun getAllCollectors() = apiService?.getCollectors()
}