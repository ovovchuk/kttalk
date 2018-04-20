fun whenTest(x: Int) {
    val validNumbers = listOf(12, 14, 17)

    when (x) {
        in 1..10 -> println("x is in the range 1..10")
        in validNumbers -> println("x is valid")
        !in 20..30 -> println("x is outside the range")
        else -> println("none of the above")
    }
}

fun forLoop() {
    val list = listOf(1, 2, 3)
    for (element in list) {
        print(element)
    }

    println()

    for ((index , element) in list.withIndex()) {
        println("Element is: $element and Index is: $index")
    }


    for (i in 1..9) { // including 9
        print(i)
    }

    println()

    // excluding 10 (the same as 1..9)
    for (i in 1 until 10) {
        print(i)
    }

    println()

    for (i in 9 downTo 1 step 2) {
        print(i)
    }

    println()
    
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")

    for ((key, value) in map) {
        println("$key = $value")
    }
}

fun main(args: Array<String>) {
    whenTest(3)
    whenTest(17)

    forLoop()
}