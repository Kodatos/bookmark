package com.kodatos.shared.domain.common

import com.kodatos.shared.network.response.GBVolumeResponse
import com.kodatos.shared.network.response.GOOGLE_ISBN_13

internal fun getBookFrom(networkBook: GBVolumeResponse): Book {
    with(networkBook.volumeInfo) {
        return Book(
            isbn = industryIdentifiers.first { it.type == GOOGLE_ISBN_13 }.identifier,
            title = title,
            subtitle = subtitle,
            primaryAuthor = authors.first(),
            authors = authors.drop(1),
            description = description,
            imageUrl = imageLinks.thumbnail ?: imageLinks.smallThumbnail,
            pageCount = pageCount,
            genres = categories,
            publisher = publisher,
            onlineRating = averageRating
        )
    }
}