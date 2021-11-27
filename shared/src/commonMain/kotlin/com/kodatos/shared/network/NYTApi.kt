package com.kodatos.shared.network

import com.kodatos.shared.BuildKonfig
import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.domain.common.Result
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class NYTApi(
    private val apiClient: ApiClient,
    private val host: NYTHost
) {

    internal suspend fun getBestsellersFor(list: BestsellerList): Result<NYTBestsellerResponse, String> {
        return apiClient.GET(
            host,
            BESTSELLER_PATH,
            urlParams = mapOf(
                "list" to list.key,
                "api-key" to BuildKonfig.NYT_API_KEY
            )
        )
    }

    companion object {
        const val BESTSELLER_PATH = "/svc/books/v3/lists.json"
    }

}

