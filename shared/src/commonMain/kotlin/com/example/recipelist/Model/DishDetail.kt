package com.example.recipelist.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DishDetailsResponse(val dishDetails: List<DishDetails>)

@Serializable
data class DishDetails (
    @SerialName("idMeal")
    val dishID: String,
    @SerialName("strMeal")
    val name: String,
    @SerialName("strCategory")
    val category: String,
    @SerialName("strInstructions")
    val instructions: String,
    @SerialName("strMealThumb")
    val thumbnailString: String
)