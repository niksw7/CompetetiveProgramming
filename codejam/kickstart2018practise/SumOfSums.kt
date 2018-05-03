package codejam.kickstart.practise
//O()
import java.io.File

private val fileName = "D-large-practice"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine()!!.toInt()
    repeat(testCases) {
        val (_, Q) = bufferedReader.readLine()!!.split(" ").map { a -> a.toInt() }
        val array = bufferedReader.readLine()!!.split(" ").map { a -> a.toLong() }
        val list = mutableListOf<Long>()
        var sum: Long
        for (i in 0 until array.size) {
            sum = array[i]
            list.add(sum)
            for (j in i + 1 until array.size) {
                sum += array[j]
                list.add(sum)
            }
        }
        list.sort()
        bufferedWriter.write("Case #${it + 1}:")
        bufferedWriter.newLine()
        repeat(Q) {
            val (l, r) = bufferedReader.readLine()!!.split(" ").map { a -> a.toInt() }
            bufferedWriter.write(list.subList(l - 1, r).sum().toString())
            println(list.subList(l - 1, r).sum())
            bufferedWriter.newLine()
        }
    }
    bufferedWriter.close()
}

