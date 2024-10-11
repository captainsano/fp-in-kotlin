package com.captainsano

object Chapter2 {
    /**
     * Exercise 2.1
     */
    fun fib(n: Int): Int {
        tailrec fun go(
            a: Int,
            b: Int,
            n: Int,
        ): Int = if (n == 0) a else go(b, a + b, n - 1)

        return go(0, 1, n)
    }

    /**
     * Exercise 2.2
     */
    val <T> List<T>.tail: List<T>
        get() = drop(1)

    val <T> List<T>.head: T
        get() = first()

    tailrec fun <A> isSorted(
        aa: List<A>,
        order: (A, A) -> Boolean,
    ): Boolean =
        when {
            aa.size <= 1 -> false
            !order(aa.head, aa.tail.head) -> false
            else -> isSorted(aa.tail, order)
        }

    /**
     * Exercise 2.3
     */
    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = { a: A -> { b: B -> f(a, b) } }

    /**
     * Exercise 2.4
     */
    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = { a, b -> f(a)(b) }
}
