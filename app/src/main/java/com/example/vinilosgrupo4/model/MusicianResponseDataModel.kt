package com.example.vinilosgrupo4.model

data class MusiciansResponseDataModel (
    val id: Long,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String,
    val albums: List<Album>,
    val performerPrizes: List<PerformerPrize>
)