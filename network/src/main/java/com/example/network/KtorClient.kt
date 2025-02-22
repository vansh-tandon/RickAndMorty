package com.example.network

import com.example.network.api.ApiConstants.BASE_URL
import com.example.network.dto.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {

    private val client = HttpClient(OkHttp){
        defaultRequest { url(BASE_URL) }

        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }

    suspend fun getCharacterById(id: Int): CharacterResponse {
        return client.get("character/$id").body()
    }
}