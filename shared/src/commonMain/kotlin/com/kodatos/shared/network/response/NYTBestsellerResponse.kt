package com.kodatos.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class NYTBestsellerResponse(
    val results: List<NYTBookItem>
)

@Serializable
data class NYTBookItem(
    val isbns: List<NYTBookISBN>,
    val rank: Int,
    val weeks_on_list: Int,
)

@Serializable
data class NYTBookISBN(
    val isbn13: String
)