package com.example.vinilosgrupo15.model

import com.google.gson.annotations.SerializedName

data class CommentDTO (
    @SerializedName("description")val description: String,
    @SerializedName("rating")val rating: String,
    @SerializedName("collector")val collector: CollectorDTO
)

data class CollectorDTO (
    @SerializedName("id")val id: Int
)
