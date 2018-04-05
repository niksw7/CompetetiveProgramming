//https://codejam.withgoogle.com/codejam/contest/9234486/dashboard#s=p1&a=1
package codejam.practise.lucky

import java.io.File

private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/practise/lucky/B-large-practice.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/practise/lucky/some.out").bufferedWriter()
fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine().toInt()
    repeat(testCases) {
        val (N, K) = bufferedReader.readLine().split(" ").map { a -> a.toInt() }
        val elements = bufferedReader.readLine().split(" ").map { a -> a.toDouble() }.sorted()
        var lastExpectedValue = elements.sum() / N
        repeat(K) {
            val index = binarySearch(elements, 0, N - 1, lastExpectedValue)
            lastExpectedValue = elements.filterIndexed { i, _ -> i > index }.map { e -> Math.max(e, lastExpectedValue) }.fold((index + 1) * lastExpectedValue, { acc, value -> value + acc }) / N
        }
        println("Case #${it + 1}: $lastExpectedValue")
        bufferedWriter.write("Case #${it + 1}: $lastExpectedValue\n")
    }
    bufferedWriter.close()
}

fun binarySearch(elements: List<Double>, start: Int, end: Int, maxValue: Double): Int {
    val mid = (start + end) / 2
    if (mid <= start || mid >= end) {
        return if ((elements[start] >= maxValue)) {
            start - 1
        } else {
            end - 1
        }
    }
    return if (elements[mid - 1] <= maxValue && elements[mid] > maxValue)
        return mid - 1
    else if (elements[mid] < maxValue) {
        binarySearch(elements, mid + 1, end, maxValue)
    } else
        binarySearch(elements, start, mid - 1, maxValue)
}
