package com.example.recipelist

import com.example.recipelist.Manager.DishManager
import com.example.recipelist.Model.DishModel
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlin.random.Random
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform = getPlatform()
    private val rocketComponent = RocketComponent()
    private val dishManager = DishManager()

    @NativeCoroutines
    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}")
        delay(1.seconds)
        emit(daysPhrase())
        emit(rocketComponent.launchPhrase())
    }

    @NativeCoroutines
    fun fetchMeals(): Flow<List<DishModel>> = flow {
        emit(dishManager.fetchMeals())
    }
}