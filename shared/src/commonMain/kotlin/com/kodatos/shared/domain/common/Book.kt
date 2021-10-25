package com.kodatos.shared.domain.common

data class Book(
    val isbn: String,
    val title: String,
    val subtitle: String?,
    val authors: List<String>,
    val description: String,
    val imageUrl: String,
    val pageCount: Int,
    val category: String,
) {
}