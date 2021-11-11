package com.kodatos.shared.cache

interface MemoryCache<K, V> {

    val size: Int

    fun has(key: K): Boolean
    fun get(key: K): V?

    /**
     * @return if
     */
    fun set(key: K, value: V)
    fun invalidateAll()
    fun invalidate(key: K)

}