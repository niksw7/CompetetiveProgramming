package hackercup.qualifier
/**
 * Problem : https://www.facebook.com/hackercup/problem/1632703893518337/
 */
import java.io.File

private val fileName = "tourist"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.txt").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
        val campuses = bufferedReader.readLine().toInt()
    repeat(campuses, foreachCampus())
    bufferedWriter.close()
}

private fun foreachCampus(): (Int) -> Unit {
    return { campusNum ->
        val (N, K, V) = bufferedReader.readLine().split(" ").map(String::toLong)
        val array = Array(N.toInt()) { bufferedReader.readLine() }

        var position: Int = (K * (V - 1) % N).toInt()
        val sb = StringBuilder()
        val prepender = StringBuilder()
        repeat(K.toInt()) {
            position %= N.toInt()
            if (position == 0 || prepender.isNotEmpty())
                prepender.append(array[position] + " ")
            else
                sb.append(array[position] + " ")
            position++
        }
        bufferedWriter.write("Case #${campusNum + 1}: ${prepender.append(sb).trim()}\n")
    }
}
