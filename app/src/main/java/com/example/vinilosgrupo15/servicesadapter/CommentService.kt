package com.example.vinilosgrupo15.servicesadapter

import com.example.vinilosgrupo15.model.CommentDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {

    @Headers("Content-Type: application/json")
    @POST("/albums/{albumId}/comments")
    suspend fun addComment(@Path("albumId") albumId: Long, @Body commentDTO: CommentDTO): Response<CommentDTO>
}