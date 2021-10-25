package com.kodatos.shared.domain.common

sealed class Result<out T, out E> {
    open class SUCCESS<T>(val value: T) : Result<T, Nothing>()
    open class ERROR<E>(val error: E) : Result<Nothing, E>()

    fun isSuccess() = this is SUCCESS
}

fun <T> Result<T, *>.getOrNull(): T? {
    return if (this is Result.SUCCESS)
        this.value
    else null
}

fun <T, E> Result<T, E>.getOrElse(provider: (E) -> T): T? {
    return when (this) {
        is Result.SUCCESS -> this.value
        is Result.ERROR -> provider(this.error)
    }
}
