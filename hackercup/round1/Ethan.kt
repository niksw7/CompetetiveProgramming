package hackercup

/**
 * HackerCup Problem: https://www.facebook.com/hackercup/problem/232395994158286/
 * This is an orthodox approach on solving it.
 * The core algorithm lies here in function :poolTheElements
 * Here's the logic used to solve the problem
 * If you have got
 * preorder = 1,2,3,4
 * postorder= 4,3,2,1
 * then according to the problem statement, they want to rename the elements in a way such that preorder and postorder give same results.
 * The key here is preorder[i] == postorder[i] == samelabel and for that, i did
 * [ preorder[0],postorder[0] ] ==> some variable
 * [1,4]==> p
 * [2,3]==> q
 * [3,4]==> q(because 3 is already q in above line, so you are forced to use only q here)
 * [1,4]==> p(because 1,4 are already assigned p here)
 * Now you can choose maximum of 2 variables here (p,q) as (1,2) or (2,1) and if K demands more than 2 it's Impossible.
 */
import java.io.File

private val fileName = "ethan_traverses_a_tree"
private val bufferedReader = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.txt").bufferedReader()
private val bufferedWriter = File("/Users/nikeshshetty/ProjectFactory/everydevelopermustknow/src/hackercup/io/$fileName.out").bufferedWriter()


fun main(args: Array<String>) {
    val T = bufferedReader.readLine().toInt()
    repeat(T) {
        bufferedWriter.write("Case #${it + 1}: ${solutionforEachTree().trim()}\n")
    }
    bufferedWriter.flush()
    bufferedReader.close()
}

fun solutionforEachTree(): String {
    val preorderList = mutableListOf<Int>()
    val pool = mutableListOf<MutableSet<Int>>()
    val postOrderList = mutableListOf<Int>()

    val (N, K) = bufferedReader.readLine().split(" ").map(String::toInt)
    val graph = Array(N) { Pair(-1, -1) }
    for (i in 0 until N) {
        val (left, right) = bufferedReader.readLine().split(" ").map(String::toInt)
        graph[i] = Pair(left - 1, right - 1)
    }
    preorder(graph, 0, preorderList)
    postorder(graph, 0, postOrderList)

    poolTheElements(pool, preorderList, postOrderList)

    if (pool.size < K) {
        return "Impossible"
    }
    val arr = Array(preorderList.size) { 0 }

    for (i in 0 until preorderList.size) {
        for (p in 0 until pool.size) {
            if (pool[p].contains(preorderList[i])) {
                arr[preorderList[i]] = p % K + 1
            }
        }
    }

    return arr.map(Int::toString).reduce { a, b -> "$a $b" }
}

fun poolTheElements(pool: MutableList<MutableSet<Int>>, preorder: MutableList<Int>, postOrder: MutableList<Int>) {
    for (i in 0 until preorder.size) {
        var added = false
        var lastAdded = -1
        var p = -1
        while (++p < pool.size) {
            if (matchesElementInPool(pool, p, preorder, i, postOrder)) {
                if (added && lastAdded != p) {
                    pool[lastAdded].addAll(pool[p])
                    pool.removeAt(p)
                    p--
                } else {
                    pool[p].add(preorder[i])
                    pool[p].add(postOrder[i])
                    added = true
                    lastAdded = p
                }
            }
        }
        if (!added) {
            pool.add(mutableSetOf(preorder[i], postOrder[i]))
        }
    }
}

fun matchesElementInPool(pool: MutableList<MutableSet<Int>>, p: Int, preorder: MutableList<Int>, i: Int, postOrder: MutableList<Int>) =
        pool[p].contains(preorder[i]) || pool[p].contains(postOrder[i])


fun preorder(graph: Array<Pair<Int, Int>>, node: Int, preorderList: MutableList<Int>) {
    preorderList.add(node)
    if (graph[node].first != -1) {
        preorder(graph, graph[node].first, preorderList)
    }
    if (graph[node].second != -1) {
        preorder(graph, graph[node].second, preorderList)
    }
}

fun postorder(graph: Array<Pair<Int, Int>>, node: Int, postOrderList: MutableList<Int>) {

    if (graph[node].first != -1) {
        postorder(graph, graph[node].first, postOrderList)
    }
    if (graph[node].second != -1) {
        postorder(graph, graph[node].second, postOrderList)
    }
    postOrderList.add(node)
}
