package codejam.kickstart.practise

//Beautiful Problem Statement
/**
 * Complexity : O(logn)
Hint 1 : the middle element will always be 0 as
SN = SN-1 + "0" + switch(reverse(SN-1)).
 **/

import java.io.File

private val fileName = "B-large-practice"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.in").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/codejam/kickstart/practise/io/$fileName.out").bufferedWriter()

fun main(args: Array<String>) {

    val testCase = bufferedReader.readLine().toInt()
    repeat(testCase) {
        val K = bufferedReader.readLine().toLong()
        var length = 0L
        while (length < K) {
            length = length * 2 + 1
        }

        bufferedWriter.write("Case #${it + 1}: ${string(length, K)}")
        bufferedWriter.newLine()
    }
    bufferedWriter.close()
}

private fun string(length: Long, K: Long) = if (isOne(length, K - 1)) 1 else 0
/**
 * The first 2 conditions are straight forward.Just read the code. The condition of K greater or equal to mid, says that if
S3 = "0010011"
S4 = "0010011 0 0011011" (spaces added for readability)
The part after 0 is nothing but negation and reversed of S3, so if K =10 on mapping to 0 based indexing K=9,
and hence in S4, mid =7, 2 places to right is 9 which is nothing but last(since it was reversed) 2 places of S3 negated(since it was switched)
 */
fun isOne(length: Long, K: Long): Boolean {
    val mid = length / 2
    if (mid == K) {
        return false
    }
    return if (K < mid) {
        isOne(mid, K)
    } else {
        !isOne(mid, mid - (K - mid))
    }
}

