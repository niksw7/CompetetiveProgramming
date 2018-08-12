package codejam
/**
 * Problem : https://codejam.withgoogle.com/codejam/contest/9234486/dashboard#s=p2&a=1
 */
import java.io.File

val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/large.in").bufferedReader()
fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine().toInt()
    val bw = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/large.out.txt").bufferedWriter()
    repeat(testCases) {
        val message = "Case #${it + 1}: ${getAnswer()}"
        println(message)
        bw.write(message)
        bw.newLine()
    }
    bw.close()
}

fun getAnswer(): Int {
    var count = 0
    val (str, map) = readInput()
    for (i in 0 until str.length) {
        if (map.containsKey(str[i])) {
            val elementsTobeRemoved = mutableListOf<Int>()
            val listOfElements = map[str[i]]!!
            val size = listOfElements.size
            for (i in 0 until size) {
                val element = listOfElements[i]
                val proposedLastIndex = i + element.length - 1
                if (proposedLastIndex < str.length && str[proposedLastIndex] == element.last()) {
                    val substring = str.substring(i, proposedLastIndex + 1)
                    if (substring.length == element.length && substring.toList().sorted() == element.toList().sorted()) {
                        count++
                        elementsTobeRemoved.add(i)
                    }
                } else if (proposedLastIndex >= str.length) {
                    elementsTobeRemoved.add(i)
                }
            }
            elementsTobeRemoved.forEach { index -> listOfElements.removeAt(index) }
            if (listOfElements.isEmpty()) {
                map.remove(str[i])
            }
            if (map.isEmpty()) {
                return count
            }
        }
    }

    return count
}


private fun readInput(): Pair<String, MutableMap<Char, MutableList<String>>> {
    val L = bufferedReader.readLine()!!.toInt() //count of dictionary words
    val map = mutableMapOf<Char, MutableList<String>>()
    bufferedReader.readLine()!!.split(" ").map(generateAMap(map))
    val list = bufferedReader.readLine()!!.split(" ")//S1,S2,N,A,B,C,D
    val S1 = list[0][0]

    val S2 = list[1][0]
    val N = list[2].toInt()
    val A = list[3].toLong()
    val B = list[4].toLong()
    val C = list[5].toLong()
    val D = list[6].toLong()
    val x1 = S1.toLong()
    val x2 = S2.toLong()
    val generatedString = StringBuilder(N)
    val older: LongArray = longArrayOf(x1, x2)
    generatedString.append(S1)
    generatedString.append(S2)
    for (i in 2 until N) {
        val xi: Long = (A * older[1] + B * older[0] + C) % D
        older[0] = older[1]
        older[1] = xi
        generatedString.append(getithString(xi))
    }
    return Pair(generatedString.toString(), map)
}

private fun generateAMap(map: MutableMap<Char, MutableList<String>>): (String) -> Any {
    return { word ->
        val firstChar = word[0]
        if (map.containsKey(firstChar)) {
            map[firstChar]!!.add(word)
        } else {
            map[firstChar] = mutableListOf(word)
        }
    }
}

private fun getithString(xi: Long) = ('a'.toLong() + (xi % 26)).toChar()
