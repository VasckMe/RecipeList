package com.example.recipelist

import com.example.recipelist.Manager.DishManager
import com.example.recipelist.Model.DishModel

class Greeting {
    private val platform = getPlatform()
    private val dishManager = DishManager()

    suspend fun fetchMeals(): List<DishModel> {
        return dishManager.fetchMeals()
    }
}