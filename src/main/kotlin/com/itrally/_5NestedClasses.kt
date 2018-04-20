package com.itrally

class Outer {
    private val outerProperty: String = "Outer property"

    class Nested {
        fun foo() = "Output from foo() function"
    }

    inner class Inner {
        fun bar() = outerProperty
    }
}

fun main(args: Array<String>) {
    val nested = Outer.Nested()
    println(nested.foo())

    val inner = Outer().Inner()
    println(inner.bar())
}