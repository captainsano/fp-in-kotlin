package com.captainsano

object Chapter3 {
    sealed class List<out A> {
        companion object {
            fun <A> of(vararg aa: A): List<A> {
                val tail = aa.sliceArray(1 until aa.size)
                return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
            }
        }
    }

    data object Nil : List<Nothing>()

    data class Cons<out A>(
        val head: A,
        val tail: List<A>,
    ) : List<A>()

    /**
     * Exercise 3.1
     */
    fun <A> tail(xs: List<A>): List<A> =
        when (xs) {
            is Nil -> Nil
            is Cons -> xs.tail
        }

    /**
     * Exercise 3.2
     */
    fun <A> setHead(
        xs: List<A>,
        x: A,
    ): List<A> =
        when (xs) {
            is Nil -> Cons(x, Nil)
            is Cons -> Cons(x, xs)
        }

    /**
     * Exercise 3.3
     */
    tailrec fun <A> drop(
        l: List<A>,
        n: Int,
    ): List<A> =
        if (n == 0 || l is Nil) {
            l
        } else {
            drop(tail(l), n - 1)
        }

    /**
     * Exercise 3.4
     */
    tailrec fun <A> dropWhile(
        l: List<A>,
        f: (A) -> Boolean,
    ): List<A> =
        when (l) {
            is Nil -> Nil
            is Cons -> if (f(l.head)) dropWhile(l.tail, f) else l
        }

    fun <A> append(
        l1: List<A>,
        l2: List<A>,
    ): List<A> =
        when (l1) {
            is Nil -> l2
            is Cons -> Cons(l1.head, append(l1.tail, l2))
        }

    /**
     * Exercise 3.5
     */
    fun <A> init(l: List<A>): List<A> =
        when (l) {
            is Nil -> Nil
            is Cons ->
                when (l.tail) {
                    is Nil -> Nil
                    is Cons -> Cons(l.head, init(l.tail))
                }
        }
}
