package hackercup.qualifier
/**
 * Problem : https://www.facebook.com/hackercup/problem/175329729852444/
 */
import java.io.File

private val fileName = "interception"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.txt").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {
    val T = bufferedReader.readLine().toInt()
    repeat(T) {
        val N = bufferedReader.readLine().toInt()
        repeat(N + 1) {
            bufferedReader.readLine()
        }
        if (N % 2 == 0) {
            bufferedWriter.write("Case #${it + 1}: 0\n")
        } else {
            bufferedWriter.write("Case #${it + 1}: 1 \n0.0\n")
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}