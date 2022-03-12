package com.kodatos.shared.domain.bookshelf

import com.kodatos.shared.domain.unit.Action

sealed interface BookshelfAction : Action {
    object ExpandClick : BookshelfAction
}