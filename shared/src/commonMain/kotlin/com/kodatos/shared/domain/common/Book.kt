package com.kodatos.shared.domain.common

interface BookInfo {
    val isbn: String
    val title: String
    val subtitle: String?
    val primaryAuthor: String
    val authors: List<String>?
    val description: String
    val imageUrl: String?
    val pageCount: Int
    val genres: List<String>?
    val publisher: String?
    val onlineRating: Double?
}

data class Book(
    override val isbn: String,
    override val title: String,
    override val subtitle: String?,
    override val primaryAuthor: String,
    override val authors: List<String>?,
    override val description: String,
    override val imageUrl: String?,
    override val pageCount: Int,
    override val genres: List<String>?,
    override val publisher: String?,
    override val onlineRating: Double?
) : BookInfo {
}

data class SavedBook(val book: Book, val userRating: Double): BookInfo by book