package com.kodatos.shared.network

import com.kodatos.shared.BuildKonfig
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.network.response.NetworkResult
import me.tatarka.inject.annotations.Inject

@Inject
internal class NYTApi(private val apiClient: ApiClient) {

    internal suspend fun getBestsellersFor(list: BestsellerList): NetworkResult<NYTBestsellerResponse> {
        return apiClient.GET(
            URL_HOST,
            "/svc/books/v3/lists.json",
            urlParams = mapOf(
                "list" to list.key,
                "api-key" to BuildKonfig.NYT_API_KEY
            )
        )
    }

    companion object {
        private const val URL_HOST = "api.nytimes.com"

    }
}