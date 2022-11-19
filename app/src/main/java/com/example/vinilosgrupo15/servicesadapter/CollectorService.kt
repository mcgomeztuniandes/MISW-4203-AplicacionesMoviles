package com.example.vinilosgrupo15.servicesadapter
import com.example.vinilosgrupo15.model.CollectorsResponseDataModel

import retrofit2.Response
import retrofit2.http.GET

interface CollectorService {

    @GET("collectors")
    suspend fun getCollectors(): Response<ArrayList<CollectorsResponseDataModel>>
}