package com.kodatos.shared.network

import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.common.Result
import com.kodatos.shared.network.response.GBSearchResponse
import com.kodatos.shared.network.response.GBVolumeResponse
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class GoogleBooksAPI(
    private val apiClient: ApiClient,
    private val host: GoogleBooksHost
) {

    suspend fun searchByISBN(isbn: String): Result<GBSearchResponse, String> {
        return apiClient.GET(
            host,
            SEARCH_PATH,
            mapOf("q" to "isbn:$isbn")
        )
    }

    suspend fun getVolumeInfo(id: String): Result<GBVolumeResponse, String> {
        return apiClient.GET(
            host,
            "$SEARCH_PATH/$id",
            mapOf()
        )
    }

    companion object {
        const val SEARCH_PATH = "/books/v1/volumes"
    }
}
