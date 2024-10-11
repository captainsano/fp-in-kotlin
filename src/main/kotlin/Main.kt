package com.captainsano

fun main() {
    val sum = { a: Int, b: Int -> a + b }

    val sumCurry = Chapter2.curry(sum)
    val add5 = sumCurry(5)

    val add = Chapter2.uncurry(sumCurry)

    println("curried: ${sumCurry(1)(2)}")
    println("add5: ${add5(10)}")

    println("add: ${add(20, 5)}")
}
