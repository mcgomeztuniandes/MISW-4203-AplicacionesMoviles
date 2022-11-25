package com.example.vinilosgrupo15.repository

import com.example.vinilosgrupo15.model.CommentDTO
import com.example.vinilosgrupo15.servicesadapter.CommentService
import com.example.vinilosgrupo15.servicesadapter.RetrofitClient

class CommentRepository {
    private var apiService: CommentService? = null

    init {
        apiService = RetrofitClient.getClient?.create(CommentService::class.java)
    }

    suspend fun addComment(id_album: Long, commentDTO: CommentDTO) = apiService?.addComment(id_album, commentDTO)
}