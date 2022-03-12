package com.kodatos.shared.domain.explore

import com.kodatos.shared.domain.common.BookInfo

data class ExploreBook(
    val title: String,
    val imageUrl: String?,
)

fun BookInfo.toExploreBook() = ExploreBook(title, imageUrl)

fun List<BookInfo>.toExploreBookList() = map { it.toExploreBook() }