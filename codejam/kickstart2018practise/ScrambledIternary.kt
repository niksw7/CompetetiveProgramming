package codejam.kickstart.practise
//O(n)
import java.io.File

private val fileName = "C-large-practice"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine().toInt()
    repeat(testCases) {
        val N = bufferedReader.readLine().toInt()
        val map = mutableMapOf<String, Int>()
        val sourcelist = mutableListOf<String>()
        val destlist = mutableListOf<String>()
        repeat(N) {
            val source = bufferedReader.readLine()
            val dest = bufferedReader.readLine()
            map.merge(source, 1, Integer::sum)
            map.merge(dest, 1, Integer::sum)
            sourcelist.add(source)
            destlist.add(dest)
        }
        val (a, b) = map.filterValues { v -> v != 2 }.map { k -> k.key }
        val sourceElement = if (sourcelist.contains(a)) a else b
        var nextIndex = sourcelist.indexOf(sourceElement)
        val sb = StringBuilder()
        repeat(N) {
            sb.append("${sourcelist[nextIndex]}-${destlist[nextIndex]} ")
            nextIndex = sourcelist.indexOf(destlist[nextIndex])
        }
        bufferedWriter.write("Case #${it + 1}: $sb")
        bufferedWriter.newLine()
    }
    bufferedWriter.close()
}
