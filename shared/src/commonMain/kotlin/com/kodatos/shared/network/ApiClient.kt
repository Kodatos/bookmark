package com.kodatos.shared.network

import com.kodatos.shared.BuildKonfig
import com.kodatos.shared.domain.common.Result
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.cache.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import me.tatarka.inject.annotations.Inject

/**
 * An API client facade that exposes generic REST methods which other specific API classes
 * should use
 */
@Inject
internal class ApiClient() {
    private val ktorClient by lazy {
        HttpClient {
            expectSuccess = false
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    isLenient = true
                    explicitNulls = false
                })
            }
            install(HttpCache)
            Charsets {
                val utf8 = io.ktor.utils.io.charsets.Charsets.UTF_8
                register(utf8)
                sendCharset = utf8
                responseCharsetFallback = utf8
            }
            if (BuildKonfig.DEBUG) {
                Logging {
                    level = LogLevel.ALL
                    logger = object : Logger {
                        override fun log(message: String) {
                            Napier.d(message, tag = "ApiClient")
                        }
                    }
                }
            }
        }
    }

    internal suspend inline fun <reified T> GET(
        urlHost: String,
        urlPath: String,
        urlParams: Map<String, String>,
        headers: Map<String, String> = mapOf(),
        isHttps: Boolean = true
    ): Result<T, String> {
        return parseResponse(ktorClient.get {
            url {
                protocol = if (isHttps) URLProtocol.HTTPS else URLProtocol.HTTP
                host = urlHost
                encodedPath = urlPath
            }
            urlParams.forEach {
                parameter(it.key, it.value)
            }
            headers {
                headers.forEach {
                    header(it.key, it.value)
                }
                if(HttpHeaders.Accept !in headers)
                    header(HttpHeaders.Accept, "application/json")
            }
        })
    }

    private suspend inline fun <reified T> parseResponse(
        response: HttpResponse
    ): Result<T, String> {
        return if(response.status == HttpStatusCode.OK){
            NetworkSuccess(response.receive())
        } else {
            val error = NetworkError(response.receive(), response.status)
            Napier.w(error.error)
            error
        }
    }
}
