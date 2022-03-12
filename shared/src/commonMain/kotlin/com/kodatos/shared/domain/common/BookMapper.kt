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
            imageUrl = getBookImageUrl(networkBook),
            pageCount = pageCount,
            genres = categories,
            publisher = publisher,
            onlineRating = averageRating
        )
    }
}

internal fun getBookImageUrl(gbVolumeResponse: GBVolumeResponse): String {
    return "https://books.google.com/books/content?id=${gbVolumeResponse.id}&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
}