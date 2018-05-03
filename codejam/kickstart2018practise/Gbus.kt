package codejam.kickstart.practise
//O(n)
import java.io.File

private val fileName = "A-large-practice"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val testCases = bufferedReader.readLine()!!.toInt()
    repeat(testCases) {
        val noOfbuses = bufferedReader.readLine()!!.toInt()
        val citiesCovered = bufferedReader.readLine().trim().split(" ").map { a -> a.toInt() }
        val p = bufferedReader.readLine().trim()!!.toInt()
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val array = Array(5001, { 0 })
        for (i in 0 until citiesCovered.size step 2) {
            for (j in citiesCovered[i]..citiesCovered[i + 1]) {
                array[j] += 1
            }
            min = Math.min(citiesCovered[i], min)
            max = Math.max(citiesCovered[i + 1], max)

        }
        bufferedWriter.write("\nCase #${it + 1}:")
        repeat(p) {
            val city = bufferedReader.readLine().trim()!!.toInt()
            bufferedWriter.write(" ${array[city]}")
        }
        if (it != testCases - 1)
            bufferedReader.readLine().trim()
    }
    bufferedWriter.close()
}
