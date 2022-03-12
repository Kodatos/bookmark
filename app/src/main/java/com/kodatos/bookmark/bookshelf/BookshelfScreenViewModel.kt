package com.kodatos.bookmark.bookshelf

import androidx.lifecycle.viewModelScope
import com.kodatos.bookmark.base.BaseScreenViewModel
import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventConsumer
import com.kodatos.shared.domain.bookshelf.BookshelfAction
import com.kodatos.shared.domain.bookshelf.BookshelfDomainUnit
import com.kodatos.shared.domain.bookshelf.BookshelfState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookshelfScreenViewModel @Inject constructor(
    private val bookshelfDomainUnit: BookshelfDomainUnit,
    eventConsumer: EventConsumer,
    dispatchers: DispatcherProvider
) : BaseScreenViewModel<BookshelfState, BookshelfAction>(
    bookshelfDomainUnit,
    eventConsumer,
    dispatchers
) {

    fun onExpandIconClick() {
        viewModelScope.launch {
            bookshelfDomainUnit.dispatch(BookshelfAction.ExpandClick)
        }
    }
}