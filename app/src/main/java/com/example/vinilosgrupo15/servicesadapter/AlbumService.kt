package com.example.vinilosgrupo15.servicesadapter
import com.example.vinilosgrupo15.model.AlbumResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): Response<ArrayList<AlbumResponseDataModel>>
}
