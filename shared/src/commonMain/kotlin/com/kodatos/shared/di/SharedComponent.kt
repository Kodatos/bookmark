package com.kodatos.shared.di

import com.kodatos.shared.cache.BookDetailsCache
import com.kodatos.shared.cache.MemoryCache
import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.domain.explore.ExploreDomainUnit
import com.kodatos.shared.network.GoogleBooksHost
import com.kodatos.shared.network.NYTHost
import com.kodatos.shared.repo.BookmarkRepoImpl
import com.kodatos.shared.repo.BookmarkRepository
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@SharedSingleton
@Component
internal abstract class SharedComponent(@get:Provides private val args: SharedComponentArgs) {

    protected abstract val repository: BookmarkRepository
    abstract val exploreDomainUnit: ExploreDomainUnit

    protected val BookmarkRepoImpl.bind: BookmarkRepository
       @SharedSingleton @Provides get() = this


    @Provides
    fun bookCache(): MemoryCache<String, Book> = BookDetailsCache(args.bookCacheSize)

    @Provides
    fun NytHost(): NYTHost = "api.nytimes.com"

    @Provides
    fun GoogleBooksHost(): GoogleBooksHost = "www.googleapis.com"

    internal data class SharedComponentArgs(val bookCacheSize: Int)
}

