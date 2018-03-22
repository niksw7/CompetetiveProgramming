package codeforce

/*
http://codeforces.com/contest/954/problem/B
 */
fun main(args: Array<String>) {
    readLine()!!.toInt()
    val str = readLine()!!
    var state = 0
    var maxlength = 0
    var currLength = 0
    var lastUnmatchedIndex = 0
    str.forEachIndexed { it, character ->
        if (it != 0) {
            if (str[state] == character && lastUnmatchedIndex >= state) {
                currLength++
                state++
                maxlength = Math.max(currLength, maxlength)
            } else {
                lastUnmatchedIndex = it
                currLength = 0
                state = 0
            }
        }

    }
    println(str.length - Math.max(maxlength - 1, 0))

}