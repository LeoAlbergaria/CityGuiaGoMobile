package com.pi.cityguiago.network

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiClient {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend inline fun <reified T> get(url: String, headers: Map<String, String> = emptyMap()): T {
        return client.get(url) {
            headers.forEach { (key, value) -> header(key, value) }
        }.body()
    }

    suspend inline fun <reified T> post(url: String, body: Any, headers: Map<String, String> = emptyMap()): T {
        return client.post(url) {
            contentType(ContentType.Application.Json)
            headers.forEach { (key, value) -> header(key, value) }
            setBody(body)
        }.body<T>()
    }

    suspend inline fun <reified T> put(url: String, body: Any, headers: Map<String, String> = emptyMap()): T {
        return client.put(url) {
            contentType(ContentType.Application.Json)
            headers.forEach { (key, value) -> header(key, value) }
            setBody(body)
        }.body()
    }

    suspend fun delete(url: String, headers: Map<String, String> = emptyMap()): HttpResponse {
        return client.delete(url) {
            headers.forEach { (key, value) -> header(key, value) }
        }
    }
}