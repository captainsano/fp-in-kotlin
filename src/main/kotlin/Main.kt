package com.captainsano

fun main() {
    val myList = Chapter3.Cons(1, Chapter3.Cons(2, Chapter3.Nil))

    println("init: ${Chapter3.init(myList)}")
}
