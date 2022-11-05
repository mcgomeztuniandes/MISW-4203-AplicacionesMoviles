package com.example.vinilosgrupo15.model

data class MusiciansResponseDataModel (
    val id: Long,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String,
    val albums: List<Album>,
    val performerPrizes: List<PerformerPrize>
)

data class BandReponseDataModel (
    val id: Long,
    val name: String,
    val image: String,
    val description: String,
    val creationDate: String,
    val albums: List<Album>,
    val musicians: List<Any?>,
    val performerPrizes: List<PerformerPrize>
)

data class Album (
    val id: Long,
    val name: String,
    val cover: String,
    val releaseDate: String,
    val description: String,
    val genre: String,
    val recordLabel: String
)

data class PerformerPrize (
    val id: Long,
    val premiationDate: String
)