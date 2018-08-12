package hackercup.qualifier

/**
 * Problem : https://www.facebook.com/hackercup/problem/1153996538071503/
 * Time Complexity: O(n)
 */
import java.io.File

private val fileName = "ethan_searches_string"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.txt").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val T = bufferedReader.readLine().toInt()

    repeat(T) {
        var answer = ""
        val str = bufferedReader.readLine()
        val firstChar = str[0]
        var index = 0
        var size = str.length
        for (i in 1 until str.length) {
            index = (index + 1) % size
            if (i != index) {
                if (str[i] != str[index]) {
                    answer = str.substring(0, size) + str
                    break
                }
            } else if (firstChar == str[i]) {
                size = i
            }
        }
        if (answer.isEmpty()) {
            bufferedWriter.write("Case #${it + 1}: Impossible\n")
        } else
            bufferedWriter.write("Case #${it + 1}: $answer\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}

fun find(s1: String, s2: String): Boolean {
    var i = 1
    var j = 1
    while (true) {
        println("$i $j")
        if (i > s1.length) {
            return true
        }
        if (j > s2.length) {
            return false
        }
        if (s1[i - 1] == s2[j - 1]) {
            i++
            j++
            continue
        } else if (i == 1) {
            j++
        } else {
            i = 1
        }

    }
}