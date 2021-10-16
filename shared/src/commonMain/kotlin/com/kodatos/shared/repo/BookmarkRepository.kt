package com.kodatos.shared.repo

import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.network.response.NetworkResult
import kotlinx.coroutines.flow.Flow

internal interface BookmarkRepository {
    suspend fun getRecommendedBooks(requiredLists: List<BestsellerList>):
            Flow<NetworkResult<NYTBestsellerResponse>>
}