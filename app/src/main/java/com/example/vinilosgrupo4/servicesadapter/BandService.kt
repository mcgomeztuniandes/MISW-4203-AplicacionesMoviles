package com.example.vinilosgrupo4.servicesadapter

import com.example.vinilosgrupo4.model.BandReponseDataModel
import retrofit2.Response
import retrofit2.http.GET

public interface BandService {
    @GET("bands")

    suspend fun getBands(): Response<ArrayList<BandReponseDataModel>>
}