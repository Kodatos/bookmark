package com.kodatos.shared.di

import com.kodatos.shared.network.NYTHost
import com.kodatos.shared.repo.BookmarkRepoImpl
import com.kodatos.shared.repo.BookmarkRepository
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@SharedSingleton
@Component
internal abstract class SharedComponent {

    protected abstract val repository: BookmarkRepository

    protected val BookmarkRepoImpl.bind: BookmarkRepository
       @SharedSingleton @Provides get() = this

    @Provides
    fun NytHost(): NYTHost = "api.nytimes.com"

}

