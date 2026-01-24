package com.example.recipelist.Manager

import com.example.recipelist.Model.DishModel
import com.example.recipelist.Model.MealsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DishManager {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchMeals(): List<DishModel> {
        val response: MealsResponse = httpClient.get("https://www.themealdb.com/api/json/v1/1/filter.php?a=polish").body()
        return response.meals
    }
}