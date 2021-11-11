package com.kodatos.shared.cache

import com.kodatos.shared.domain.common.Book

class BookDetailsCache(override val size: Int) : MemoryCache<String, Book> {

    private val _map = LinkedHashMap<String, Book>((size / 4).coerceAtLeast(24))

    override fun has(key: String): Boolean {
        return key in _map
    }

    override fun get(key: String): Book? {
        val book = _map[key]
        if(book != null){
            _map.remove(key)
            _map.put(key, book)
        }
        return book
    }

    override fun set(key: String, value: Book) {
        val iterator = _map.entries.iterator()
        while (_map.size > size && iterator.hasNext()){
            iterator.next()
            iterator.remove()
        }
        _map[key] = value
    }

    override fun invalidateAll() {
        _map.clear()
    }

    override fun invalidate(key: String) {
        _map.remove(key)
    }
}