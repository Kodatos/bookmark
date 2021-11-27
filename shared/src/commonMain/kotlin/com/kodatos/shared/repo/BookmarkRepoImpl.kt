package com.kodatos.shared.repo

import com.kodatos.shared.cache.MemoryCache
import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.network.NYTApi
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.domain.common.Result
import com.kodatos.shared.domain.common.getBookFrom
import com.kodatos.shared.network.GoogleBooksAPI
import com.kodatos.shared.network.response.GOOGLE_ISBN_13
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class BookmarkRepoImpl(
    private val nytApi: NYTApi,
    private val googleBooksAPI: GoogleBooksAPI,
    private val booksCache: MemoryCache<String, Book>
) : BookmarkRepository {
    override suspend fun getRecommendedBooks(requiredLists: List<BestsellerList>):
            Flow<Result<NYTBestsellerResponse, String>> {
        return flow {
            requiredLists.forEach {
                emit(nytApi.getBestsellersFor(it))
            }
        }
    }

    override suspend fun getBookDetails(isbn: String): Result<Book, String> {
        val cachedBook = booksCache.get(isbn)
        if (cachedBook != null) {
            return Result.SUCCESS(cachedBook)
        } else {
            val searchResponse = googleBooksAPI.searchByISBN(isbn)
            if (searchResponse is Result.ERROR)
                return searchResponse

            val searchedItem = (searchResponse as Result.SUCCESS).value.items?.find {
                it.volumeInfo.industryIdentifiers.find { it.type == GOOGLE_ISBN_13 }?.identifier == isbn
            } ?: return Result.ERROR<String>("Couldn't find a book for this ISBN: $isbn")

            val mappedBook = getBookFrom(searchedItem)
            booksCache.set(isbn, mappedBook)
            return Result.SUCCESS<Book>(mappedBook)
        }
    }
}