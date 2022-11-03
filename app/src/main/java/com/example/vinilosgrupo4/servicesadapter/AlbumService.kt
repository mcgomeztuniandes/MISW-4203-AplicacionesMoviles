package com.example.vinilosgrupo4.servicesadapter
import com.example.vinilosgrupo4.model.AlbumResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): Response<ArrayList<AlbumResponseDataModel>>
}
