package codeforce

/*
http://codeforces.com/contest/954/problem/A
 */
fun main(args: Array<String>) {
    readLine()!!.toInt()
    var previous = 'D'
    var count = 0
    val readLine = readLine()!!
    readLine.forEach { c ->
        previous = if (previous != 'D' && c != previous) {
            count++
            'D'
        } else {
            c
        }
    }
    println(readLine.length - count)

}