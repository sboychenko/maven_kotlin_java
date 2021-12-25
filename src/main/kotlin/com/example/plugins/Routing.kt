package com.example.plugins

import com.test.Test
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            Test.test()
            call.respondText("Hello World!")
        }
    }
    routing {
    }
}
