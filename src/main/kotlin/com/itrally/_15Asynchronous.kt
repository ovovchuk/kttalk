package com.itrally

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

suspend fun function1(): Int {
    delay(1000)
    return 5
}

suspend fun function2(): Int {
    delay(1000)
    return 10
}

fun main(args: Array<String>) {
    runBlocking {
        val timeMillis = measureTimeMillis {
            val res1 = function1()
            val res2 = function2()
            println("Result: ${res1 + res2}")
        }
        println("Sequential total time: $timeMillis ms")
    }

    runBlocking {
        val timeMillis = measureTimeMillis {
            val res1 = async { function1() }
            val res2 = async { function2() }
            println("Result: ${res1.await() + res2.await()}")
        }
        println("Concurrent total time: $timeMillis ms")
    }
}
