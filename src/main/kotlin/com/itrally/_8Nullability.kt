package com.itrally

fun main(args: Array<String>) {

    val s1: String = "always not null"
    val s2: String? = null

    val i1: Int = s1.length
    // s2.length

    val i2: Int? = if (s2 != null) s2.length else null
    val i3: Int? = s2?.length

    val i4: Int = s2?.length ?: 0

//    s2!!
}
