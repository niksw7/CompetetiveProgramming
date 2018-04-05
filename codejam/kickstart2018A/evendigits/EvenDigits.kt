//https://codejam.withgoogle.com/codejam/contest/9234486/dashboard#s=p0&a=1
package codejam.practise.evendigits

fun main(args: Array<String>) {
    val testCase = readLine()!!.toInt()
    repeat(testCase) {
        println("Case #${it + 1}: ${getValue(readLine()!!)}")
    }
}


fun getValue(number: String): Long {
    var lower = StringBuilder()
    var upper = StringBuilder()
    for (i in 0 until number.length) {
        val num = number[i].toString().toInt()
        if (num % 2 != 0) {
            lower.append(number.subSequence(0, i), num - 1)
            repeat(number.length - i - 1) {
                lower.append(8)
            }
            if (num == 9) {
                return number.toLong() - lower.toString().toLong()
            }
            upper.append(number.subSequence(0, i), num + 1)
            repeat(number.length - i - 1) {
                upper.append(0)
            }
            return Math.min(number.toLong() - lower.toString().toLong(), upper.toString().toLong() - number.toLong())
        }

    }
    return 0
}

