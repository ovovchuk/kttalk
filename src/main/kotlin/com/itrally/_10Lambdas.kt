package com.itrally

fun transform(value: String, func: (String) -> String): String {
    return func(value)
}

fun lastWord(value: String) = value.split("\\s".toRegex()).last()

fun main(args: Array<String>) {
    val msg = "hello world"
    val uppercase = transform(msg, String::toUpperCase)
    val lastWord = transform(msg, ::lastWord)

    println(uppercase)
    println(lastWord)

    msg.filter() { c: Char -> c in 'a'..'z' }

    msg.filter { c: Char -> c in 'a'..'z' }

    msg.filter { c -> c in 'a'..'z' }

    msg.filter { it in 'a'..'z' }
}
