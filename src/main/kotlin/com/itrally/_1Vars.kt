package com.itrally

// known at compile time
const val YEAR = 2017

fun main(args: Array<String>) {
    val name: String = "Some name"
    val magicNumber = 0

    var address = "Mazepy, St"
    address = "Other, St"

    val languages = mutableListOf("Java", "Kotlin")
    languages.add("TypeScript")

    val long = 10L
    val float = 100F
    val hex = 0x0F
    val binary = 0b01

    val int = 100
    val otherLong: Long = int.toLong()
}
