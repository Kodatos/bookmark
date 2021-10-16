package com.kodatos.shared.network.response

import io.ktor.http.*

sealed class NetworkResult<out T>(val statusCode: HttpStatusCode) {

    class SUCCESS<T>(val data: T) : NetworkResult<T>(HttpStatusCode.OK)
    class ERROR(val error: String, statusCode: HttpStatusCode, val throwable: Throwable? = null) :
        NetworkResult<Nothing>(statusCode)

}