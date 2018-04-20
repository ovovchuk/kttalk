package com.itrally

class Organization(val name: String, val address: String)

class Rectangle(val height: Int, val width: Int) {

    //secondary constructors
    constructor(side: Int) : this(side, side)
}

class RectangleDestructing(height: Int, width: Int) {
    private val height: Int
    private val width: Int

    init {
        this.height = height
        this.width = width
    }

    operator fun component1() = this.height
    operator fun component2() = this.width
}

class MutableProperty {
    var counter: Int = 0
        private set

    fun updateCounter() = counter++
}

fun main(args: Array<String>) {
    val organization = Organization("Philips", "Netherlands, Amsterdam")
    val square = Rectangle(20)

    println(organization)
    println(square)

    printSeparationLine()

    val personJava = PersonJava("fn", "ln")
    println(personJava.firstName)
    println(personJava.lastName)

    printSeparationLine()

    val (_, language) = Pair(1, "Kotlin")
    println(language)

    val (rating, country, club) = Triple(1, "England", "Liverpol FC")
    println(rating)
    println(country)
    println(club)

    val (firstName, lastName) = Person("Will", "Smith")
    val (height, width) = RectangleDestructing(20, 30)
    println(height)
    println(width)

    printSeparationLine()

    val mutableProp = MutableProperty()
    println("Counter is: ${mutableProp.counter}")

    mutableProp.updateCounter()
    println("Counter is: ${mutableProp.counter}")

    printSeparationLine()

    val person1 = Person("Leo", "Messi")
    val person2 = Person("Leo", "Messi")
    println("Is content the same: ${person1 == person2}")
    println("Are references the same: ${person1 === person2}")
}
