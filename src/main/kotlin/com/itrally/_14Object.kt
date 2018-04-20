package com.itrally

object Singleton {
    fun foo() = "Foo"
}

interface Animal {
    fun say(): String
}

class Dog {
    companion object : Animal {
        override fun say() = "woof-woof"

        @JvmStatic
        fun run() = "Running fast"
    }
}

fun main(args: Array<String>) {
    println(Singleton.foo())
    println(Dog.say())
}
