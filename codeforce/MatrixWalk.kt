/**
 * Problem : http://codeforces.com/contest/954/problem/C
 * Analysis: The core of the solution lies in testing the following input.
 * 5
 * 1 2 3 5 7
 * And for that you need to understand that the last column will always be a multiple of columnsSize.
 * Didn't ring bells? Code @ line:38
 */

package codeforce

fun main(args: Array<String>) {
    val size = readLine()!!.toInt()
    var max = 0
    val set = mutableSetOf<Int>()
    val split = readLine()!!.split(" ")
    for (i in 1 until size) {
        val curr = split[i].toInt()
        val prev = split[i - 1].toInt()
        set.add(Math.abs(curr - prev))
        max = Math.max(max, Math.max(curr, prev))
    }
    when {
        set.contains(0) -> println("NO")
        set.isEmpty() -> {
            println("YES")
            println("${split[0]} 1")
        }
        set.size == 1 && set.contains(1) -> {
            println("YES")
            println("$max 1")
        }
        set.size > 2 || set.size == 2 && !set.contains(1) -> println("NO")
        else -> {
            set.remove(1)
            val columnsAssumed = set.first()
            for (i in 1 until split.size) {
                val prev = Math.min(split[i - 1].toInt(), split[i].toInt())
                val next = Math.max(split[i - 1].toInt(), split[i].toInt())
                if (prev % columnsAssumed == 0 && next - prev != columnsAssumed) {
                    println("NO")
                    return
                }
            }
            println("YES")
            println("${Math.ceil(max.toDouble() / columnsAssumed).toLong()} $columnsAssumed")
        }
    }
}
