package com.kodatos.shared.domain.explore

import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.domain.common.Result
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.domain.unit.Event
import com.kodatos.shared.domain.unit.ToastEvent
import com.kodatos.shared.repo.BookmarkRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
internal class ExploreDomainUnit(
    private val repository: BookmarkRepository
) : DomainUnit<ExploreState, ExploreAction> {
    private val _state = MutableStateFlow<ExploreState>(ExploreState.Init)

    override val state: StateFlow<ExploreState>
        get() = _state
    override val eventChannel: Channel<Event> = Channel(Channel.BUFFERED)

    override suspend fun dispatch(action: ExploreAction) {
        when (action) {
            is ExploreAction.Load -> getRecommendedBooks(action.categories)
            ExploreAction.Click -> {

            }
        }
    }

    private suspend fun getRecommendedBooks(categories: List<BestsellerList>) {
        var error: String? = null
        repository.getRecommendedBooks(categories)
            .mapNotNull { result ->
                if (result is Result.SUCCESS) {
                    val list = result.value.results.sortedWith { first, second ->
                        if (first.rank == second.rank)
                            first.weeks_on_list - second.weeks_on_list
                        else
                            first.rank - second.rank
                    }
                    list.mapNotNull {
                        it.getISBN13()?.let { isbn ->
                            repository.getBookDetails(isbn)
                        }
                    }
                } else {
                    error = (result as Result.ERROR).error
                    Napier.d(error ?: "NYT API Error")
                    null
                }
            }.collect { bookDetails ->
                val splitList = bookDetails.partition { it is Result.SUCCESS }
                val bookList = splitList.first
                    .map {
                        (it as Result.SUCCESS).value
                    }
                splitList.second.forEach {
                    Napier.d((it as Result.ERROR).error)
                }
                if (bookList.isNotEmpty()) {
                    val currState = _state.value
                    _state.value = when (currState) {
                        is ExploreState.Init, ExploreState.Error -> {
                            ExploreState.ExploreBooksState(bookList)
                        }
                        is ExploreState.ExploreBooksState -> {
                            ExploreState.ExploreBooksState(currState.books + bookList)
                        }
                    }
                }
            }
        if (_state.value is ExploreState.Init) {
            eventChannel.send(
                ToastEvent(
                    "Couldn't retrieve recommended books",
                    ToastEvent.Companion.Duration.SHORT
                )
            )
            _state.value = ExploreState.Error
        }
    }

}