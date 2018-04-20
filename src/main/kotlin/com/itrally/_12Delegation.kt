package com.itrally

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface Base {
    fun calculate(): Int
}

class BaseImpl : Base {
    override fun calculate(): Int {
        return 5
    }
}

class OtherImp : Base by BaseImpl()

class PropertyDelegation {
    val lazy: String by lazy {
        println("In lazy")
        return@lazy "Value"
    }

    var name: String by DelegateNameProperty()

    var obsProp: String by Delegates.observable("Initial", onObsChange())

    private fun onObsChange(): (KProperty<*>, String, String) -> Unit = { property, oldValue, newValue ->
        println(oldValue)
        println(newValue)
    }
}

class DelegateNameProperty {
    private var value: String = ""
    operator fun getValue(thisRef: PropertyDelegation, property: KProperty<*>): String {
        println("In reference $thisRef reading property '${property.name}'")
        return value

    }
    operator fun setValue(thisRef: PropertyDelegation, property: KProperty<*>, value: String) {
        println("In reference $thisRef setting to property '${property.name}' value '$value'")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val base = BaseImpl()
    val other = OtherImp()
    println("Base ${base.calculate()}")
    println("Other ${other.calculate()}")

    printSeparationLine()

    val delegation = PropertyDelegation()
    println(delegation.lazy)
    println(delegation.lazy)

    printSeparationLine()

    delegation.name = "Some Name"
    println(delegation.name)

    printSeparationLine()

    delegation.obsProp = "Observable New Val"

    printSeparationLine()

    delegation.obsProp = "New Val 2"
}