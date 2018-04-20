package com.itrally

@Deprecated("SomeClass is deprecated", ReplaceWith("SomeNewClass"))
typealias SomeClass = SomeNewClass

class SomeNewClass(val prop: String = "")

fun main(args: Array<String>) {
    val someClass = SomeClass()
}