package com.example.vinilosgrupo15.servicesadapter

import com.example.vinilosgrupo15.model.MusiciansResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface MusicianService {
    @GET("musicians")

    suspend fun getMusicians(): Response<ArrayList<MusiciansResponseDataModel>>
}