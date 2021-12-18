package com.kodatos.shared.network

import com.kodatos.shared.domain.common.Result
import io.ktor.http.*

sealed interface NetworkResult {
    val statusCode: HttpStatusCode
}

class NetworkSuccess<T>(data: T) :
    Result.SUCCESS<T>(data), NetworkResult {
    override val statusCode = HttpStatusCode.OK
}

class NetworkError(
    responseError: String,
    override val statusCode: HttpStatusCode,
) : Result.ERROR<String>("$statusCode : $responseError"), NetworkResult
