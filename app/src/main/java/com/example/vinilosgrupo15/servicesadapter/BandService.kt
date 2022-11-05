package com.example.vinilosgrupo15.servicesadapter

import com.example.vinilosgrupo15.model.BandReponseDataModel
import retrofit2.Response
import retrofit2.http.GET

public interface BandService {
    @GET("bands")

    suspend fun getBands(): Response<ArrayList<BandReponseDataModel>>
}