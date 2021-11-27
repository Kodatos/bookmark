package com.kodatos.shared.repo

import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.domain.common.Result
import kotlinx.coroutines.flow.Flow

internal interface BookmarkRepository {
    suspend fun getRecommendedBooks(requiredLists: List<BestsellerList>):
            Flow<Result<NYTBestsellerResponse, String>>

    suspend fun getBookDetails(isbn: String): Result<Book, String>
}