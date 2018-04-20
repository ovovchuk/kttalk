package com.itrally

fun <T> compose(f1: (T) -> T, f2: (T) -> T): (T) -> T {
    return { p -> f1(f2(p)) }
}

infix fun <T> T.transform(func: (T) -> T) = func(this)

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curry(): (P1) -> (P2) -> (P3) -> R {
    return {
        p1: P1 -> {
            p2: P2 -> {
                p3: P3 -> this(p1, p2, p3)
            }
        }
    }
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.createPartialFunction(
        p1: P1,
        partial2: Any? = null,
        partial3: Any? = null
): (P2, P3) -> R {
    return { p2: P2, p3: P3 -> this(p1, p2, p3) }
}

fun main(args: Array<String>) {
    val upperLastWord = compose(::lastWord, String::toUpperCase)
    val multiplyByTwo = { i: Int -> i * 2 }

    println("Hello World" transform upperLastWord)
    println(2 transform multiplyByTwo)

    printSeparationLine()

    val sum = { x: Int, y: Int, z: Int -> x + y + z }
    val sumCurried = sum.curry()
    val result = sumCurried(1)(2)(3)

    println(result)

    printSeparationLine()

    val addToTwo = sum.createPartialFunction(2)
    println(addToTwo(2, 3))
}
