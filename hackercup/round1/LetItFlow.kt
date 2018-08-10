package hackercup

/**
 * Problem Statement: https://www.facebook.com/hackercup/problem/180494849326631/
 */
import java.io.File

private val fileName = "let_it_flow"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.txt").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine().toInt()

    for (i in 1..testCases) {
        val cols = bufferedReader.readLine().toInt()

        val arr1 = bufferedReader.readLine().toCharArray()
        val arr2 = bufferedReader.readLine().toCharArray()
        val arr3 = bufferedReader.readLine().toCharArray()
        if (blockageDetected(cols, arr1, arr2, arr3)) {
            bufferedWriter.write("Case #$i: 0")
            bufferedWriter.newLine()
            continue
        }
        var answer = 1
        for (v in 1 until cols - 1 step 2) {
            //upper
            var current = 2
            if (arr1[v] == '#' || arr1[v + 1] == '#') {
                current -= 1
            }
            if (arr3[v] == '#' || arr3[v + 1] == '#') {
                current -= 1
            }
            if (arr2[v] == '#' || arr2[v + 1] == '#') {
                current = 0
            }
            answer = (answer * current) % 1000000007
            if (answer == 0) break
        }
        bufferedWriter.write("Case #$i: $answer")
        bufferedWriter.newLine()
    }

    bufferedWriter.close()
}

fun blockageDetected(cols: Int, arr1: CharArray, arr2: CharArray, arr3: CharArray) =
        cols == 1 || (cols) % 2 != 0 || arr1.first() == '#' || arr2.first() == '#' ||
                arr2.last() == '#' || arr3.last() == '#'
