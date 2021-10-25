package com.kodatos.shared.repo

import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.network.NYTApi
import com.kodatos.shared.network.response.NYTBestsellerResponse
import com.kodatos.shared.domain.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class BookmarkRepoImpl(
    private val nytApi: NYTApi
) : BookmarkRepository {
    override suspend fun getRecommendedBooks(requiredLists: List<BestsellerList>):
            Flow<Result<NYTBestsellerResponse, String>> {
        return flow {
            requiredLists.forEach {
                emit(nytApi.getBestsellersFor(it))
            }
        }
    }
}