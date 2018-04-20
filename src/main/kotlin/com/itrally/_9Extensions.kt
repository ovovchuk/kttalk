package com.itrally

fun String.lastChar() = this[this.length - 1]

fun String.uppercaseChar(char: Char) = replace(char, char.toUpperCase())

infix fun String.isEqual(value: String) = this == value

fun main(args: Array<String>) {
    println("abcad".uppercaseChar('a'))
    println("qwerty".lastChar())
    println("Audi" isEqual "Audi")
}

