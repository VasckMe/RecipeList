package com.example.recipelist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect val num: Int