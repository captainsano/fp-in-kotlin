package com.captainsano

fun main() {
    val order = { a: Int, b: Int -> a < b }

    println("isSorted: ${Chapter2.isSorted((1..10).toList(), order)}")
    println("isSorted: ${Chapter2.isSorted(emptyList(), order)}")
    println("isSorted: ${Chapter2.isSorted(listOf(1), order)}")
    println("isSorted: ${Chapter2.isSorted(listOf(1, 2, 4, 3), order)}")
}
