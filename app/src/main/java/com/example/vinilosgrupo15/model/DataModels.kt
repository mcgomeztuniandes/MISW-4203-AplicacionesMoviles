package com.example.vinilosgrupo15.model

import com.google.gson.annotations.SerializedName

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
data class AlbumResponseDataModel (
    val id: Long,
    val name: String,
    val cover: String,
    val releaseDate: String,
    val description: String,
    val genre: String,
    val recordLabel: String,
    val tracks: List<Track>,
    val performers: List<Performer>,
    val comments: List<Comment>
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

data class Comment (
    val id: Long,
    val description: String,
    val rating: Long
)

data class Performer (
    val id: Long,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String? = null,
    val creationDate: String? = null
)

data class Track (
    val id: Long,
    val name: String,
    val duration: String
)

data class CollectorAlbums (
    val id: Long,
    val price: Long,
    val status: String
    )

data class CollectorsResponseDataModel (
    val id: Long,
    val name: String,
    val telephone: String,
    val email: String,
    val comments: List<Comment>,
    val favoritePerformers: List<Performer>,
    val collectorAlbums: List<CollectorAlbums>
    )

data class MyAlbum (
    @SerializedName("name") val name: String?,
    @SerializedName("cover") val cover: String?,
    @SerializedName("releaseDate") val releaseDate: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("genre") val genre: String?,
    @SerializedName("recordLabel") val recordLabel: String?
)
