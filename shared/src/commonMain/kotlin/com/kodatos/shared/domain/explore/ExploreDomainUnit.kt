package com.kodatos.shared.domain.explore

import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.common.Result
import com.kodatos.shared.domain.common.getOrElse
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.domain.unit.event.ToastEvent
import com.kodatos.shared.repo.BookmarkRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.*
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class ExploreDomainUnit(
    private val repository: BookmarkRepository
) : DomainUnit<ExploreState, ExploreAction>(initialState = ExploreState.Init) {

    override suspend fun dispatch(action: ExploreAction) {
        when (action) {
            is ExploreAction.Load -> getRecommendedBooks(action.categories)
            is ExploreAction.BookClick -> {
                sendEvent(ToastEvent("Exploring ${action.book.title}", ToastEvent.Duration.LONG))
            }
        }
    }

    private suspend fun getRecommendedBooks(categories: List<BestsellerList>) {
        repository.getRecommendedBooks(categories)
            .mapNotNull { response ->

                val bookResultList = response.getOrElse {
                    Napier.d(it)
                    null
                }?.results

                bookResultList?.sortedWith { first, second ->
                    if (first.rank == second.rank)
                        first.weeks_on_list - second.weeks_on_list
                    else
                        first.rank - second.rank
                }?.mapNotNull {
                    it.getISBN13()?.let { isbn ->
                        repository.getBookDetails(isbn)
                    }
                }
            }.collect { bookDetails ->
                val splitList = bookDetails.partition { it.isSuccess() }
                val bookList = splitList.first
                    .map {
                        (it as Result.SUCCESS).value
                    }
                splitList.second.forEach {
                    Napier.d((it as Result.ERROR).error)
                }
                if (bookList.isNotEmpty()) {
                    val currState = currentState
                    setState(
                        when (currState) {
                            is ExploreState.Init, ExploreState.Error -> {
                                ExploreState.ExploreBooksState(bookList)
                            }
                            is ExploreState.ExploreBooksState -> {
                                ExploreState.ExploreBooksState(currState.books + bookList)
                            }
                        }
                    )
                }
            }
        if (currentState is ExploreState.Init) {
            sendEvent(
                ToastEvent(
                    "Couldn't retrieve recommended books",
                    ToastEvent.Duration.SHORT
                )
            )
            setState(ExploreState.Error)
        }
    }

}