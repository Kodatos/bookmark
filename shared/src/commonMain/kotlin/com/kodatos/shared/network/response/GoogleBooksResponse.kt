package com.kodatos.shared.network.response

import kotlinx.serialization.Serializable

data class GBSearchResponse(
    val items: List<GBVolumeResponse>?
)

@Serializable
data class GBVolumeResponse(
    val id: String,
    val kind: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val authors: List<String>,
    val averageRating: Double?,
    val categories: List<String>,
    val description: String,
    //val dimensions: Dimensions,
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val language: String,
    val maturityRating: String?,
    val pageCount: Int,
    val publishedDate: String?,
    val publisher: String?,
    val subtitle: String?,
    val title: String
)

/*data class Dimensions(
    val height: String,
    val thickness: String,
    val width: String
)*/

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)

@Serializable
data class IndustryIdentifier(
    val identifier: String,
    val type: String
)

const val GOOGLE_ISBN_13 = "ISBN_13"
