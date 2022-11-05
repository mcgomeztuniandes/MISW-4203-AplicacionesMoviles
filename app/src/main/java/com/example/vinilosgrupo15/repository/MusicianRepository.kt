package com.example.vinilosgrupo15.repository

import com.example.vinilosgrupo15.servicesadapter.MusicianService
import com.example.vinilosgrupo15.servicesadapter.RetrofitClient

class MusicianRepository {
    private var apiService: MusicianService? = null

    init {
        apiService = RetrofitClient.getClient?.create(MusicianService::class.java)
    }

    suspend fun getAllMusicians() = apiService?.getMusicians()
}