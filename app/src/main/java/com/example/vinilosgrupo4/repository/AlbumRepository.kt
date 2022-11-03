package com.example.vinilosgrupo4.repository
import com.example.vinilosgrupo4.servicesadapter.AlbumService
import com.example.vinilosgrupo4.servicesadapter.RetrofitClient

class AlbumRepository {
    private var apiService: AlbumService? = null

    init {
        apiService = RetrofitClient.getClient?.create(AlbumService::class.java)
    }

    suspend fun getAllAlbums() = apiService?.getAlbums()
}