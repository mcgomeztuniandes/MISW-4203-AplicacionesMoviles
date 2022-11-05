package com.example.vinilosgrupo15.model

import com.example.vinilosgrupo15.model.Album
import com.example.vinilosgrupo15.model.PerformerPrize

data class MusiciansResponseDataModel (
    val id: Long,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String,
    val albums: List<Album>,
    val performerPrizes: List<PerformerPrize>
)