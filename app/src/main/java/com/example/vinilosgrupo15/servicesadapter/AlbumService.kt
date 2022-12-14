package com.example.vinilosgrupo15.servicesadapter
import com.example.vinilosgrupo15.model.Album
import com.example.vinilosgrupo15.model.AlbumDTO
import com.example.vinilosgrupo15.model.AlbumResponseDataModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): Response<ArrayList<AlbumResponseDataModel>>

    @Headers("Content-Type: application/json")
    @POST("albums")
    suspend fun createAlbum(@Body albumData: AlbumDTO): Response<Album>
}
