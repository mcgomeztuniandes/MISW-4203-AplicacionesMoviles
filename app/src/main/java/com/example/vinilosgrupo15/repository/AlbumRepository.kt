package com.example.vinilosgrupo15.repository
import com.example.vinilosgrupo15.model.MyAlbum
import com.example.vinilosgrupo15.servicesadapter.AlbumService
import com.example.vinilosgrupo15.servicesadapter.RetrofitClient

class AlbumRepository {
    private var apiService: AlbumService? = null

    init {
        apiService = RetrofitClient.getClient?.create(AlbumService::class.java)
    }

    suspend fun getAllAlbums() = apiService?.getAlbums()
    suspend fun  createNewAlbum(data: MyAlbum) = apiService?.createAlbum(data)
}