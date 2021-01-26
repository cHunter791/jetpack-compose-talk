package com.chunter.composetalk.data

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json as KotlinJson

object DataLoader {

    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(KotlinJson {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    suspend fun getTeams(): List<Team> = try {
        val response: TeamResponse =
            client.get("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League")
        response.teams
    } catch (e: Exception) {
        Log.e("GET Teams", e.message ?: "No message", e)
        emptyList()
    }

    suspend fun getTeam(id: Int): Team? = try {
        val response: TeamResponse =
            client.get("https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$id")
        response.teams.first()
    } catch (e: Exception) {
        Log.e("GET Team $id", e.message ?: "No message", e)
        null
    }
}