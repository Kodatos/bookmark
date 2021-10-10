package com.kodatos.shared.network

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*

internal object ApiClient {
    val ktorClient by lazy {
        HttpClient {
            install(JsonFeature)
            Charsets {
                val utf8 = io.ktor.utils.io.charsets.Charsets.UTF_8
                register(utf8)
                sendCharset = utf8
                responseCharsetFallback = utf8
            }
        }
    }
}