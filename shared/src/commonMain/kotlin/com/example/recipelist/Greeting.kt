package com.example.recipelist

import kotlin.random.Random

class Greeting {
    private val platform = getPlatform()

    fun greet(): List<String> = buildList {
        add(if (Random.nextBoolean()) "Hi!" else "Hello!")
        add("Guess what this is! > ${platform.name.reversed()}!")
        add(daysPhrase())
//        val firstWord = if (Random.nextBoolean()) "Hi!" else "Hello!")
//        return "$firstWord $num Guess waht this is! > ${platform.name.reversed()}!"
    }
}