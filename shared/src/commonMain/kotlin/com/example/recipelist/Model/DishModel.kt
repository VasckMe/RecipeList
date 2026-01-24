package com.example.recipelist.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealsResponse(val meals: List<DishModel>)

@Serializable
data class DishModel (
    @SerialName("idMeal")
    val idString: String,
    @SerialName("strMeal")
    val name: String,
    @SerialName("strMealThumb")
    val thumbnailString: String
)