package codejam.practise.lucky

import java.io.File

private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/practise/lucky/B-large-practice.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/practise/lucky/B-large-practice.out").bufferedWriter()
fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine().toInt()
    repeat(testCases) {
        val (N, K) = bufferedReader.readLine().split(" ").map { a -> a.toInt() }
        //calculate the expected value when no redips allowed
        val elements = bufferedReader.readLine().split(" ").map { a -> a.toDouble() }.toList()
        var lastExpectedValue = elements.sum() / N
        repeat(K) {
            lastExpectedValue = elements.map { e -> Math.max(e, lastExpectedValue) }.sum() / N

        }
        println("Case #${it + 1}: $lastExpectedValue")
        bufferedWriter.write("Case #${it + 1}: $lastExpectedValue\n")
    }
    bufferedWriter.close()
}