package com.captainsano

fun main() {
    val sum5 = { a: Int -> a + 5 }
    val mul3 = { a: Int -> a * 3 }

    val composed = Chapter2.compose(sum5, mul3)

    println("Composed output: ${composed(5)}")
}
