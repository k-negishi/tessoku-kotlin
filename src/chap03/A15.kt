package chap03

import java.util.*

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_o
fun main() {
//    val n = readInt()
//    val a = readIntList()
    // この問題ケース"sample_01.txt"の入力がおかしそう
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = mutableListOf<Int>()
    for (i in 0 until n) {
        a.add(sc.nextInt())
    }

    val sortedSet = a.toSet().sorted()
    val b = a.map {
        sortedSet.binarySearch(it) + 1
    }

    println(b.joinToString(" "))
}


private fun read() = readln()

private fun readInt() = read().toInt()

private fun readLong() = read().toLong()

private fun readDouble() = read().toDouble()

private fun readStringList(): MutableList<String> = read().split(" ").toMutableList()

private fun readIntList(): MutableList<Int> = readStringList().map { it.toInt() }.toMutableList()

private fun readIntListFromOne(): MutableList<Int> {
    val a = listOf(0)
    val b = readStringList().map { it.toInt() }.toList()
    return (a + b).toMutableList()
}

private fun readLongList(): MutableList<Long> = readStringList().map { it.toLong() }.toMutableList()

private fun readLongListFromOne(): MutableList<Long> {
    val a = listOf(0L)
    val b = readStringList().map { it.toLong() }.toList()
    return (a + b).toMutableList()
}

private fun readDoubleList(): MutableList<Double> = readStringList().map { it.toDouble() }.toMutableList()

private fun readStringMatrix(n: Int): MutableList<MutableList<String>> {
    val matrix = mutableListOf<MutableList<String>>()
    for (i in 0 until n) {
        val list = readStringList()
        matrix.add(list)
    }
    return matrix
}

private fun readIntMatrix(n: Int): MutableList<MutableList<Int>> {
    val matrix = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        val list = readIntList()
        matrix.add(list)
    }
    return matrix
}

private fun readDoubleMatrix(n: Int): MutableList<MutableList<Double>> {
    val matrix = mutableListOf<MutableList<Double>>()
    for (i in 0 until n) {
        val list = readDoubleList()
        matrix.add(list)
    }
    return matrix
}

private fun readLongMatrix(n: Int): MutableList<MutableList<Long>> {
    val matrix = mutableListOf<MutableList<Long>>()
    for (i in 0 until n) {
        val list = readLongList()
        matrix.add(list)
    }
    return matrix
}

/**
 * 二分探索 lowerBound
 * 二分探索でvalue以上の値が現れる最初の位置を求める
 *
 * @param value 検索する値
 * @return key以上の値が現れる最初の位置
 */
private fun List<Int>.lowerBound(value: Int): Int {
    var left = 0
    var right = this.size

    while (left <= right) {
        val mid = (left + right) / 2
        if (this[mid] < value) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}

/**
 * 二分探索 lowerBound
 * 二分探索でvalue以上の値が現れる最初の位置を求める
 *
 * @param value 検索する値
 * @return value以上の値が現れる最初の位置
 */
private fun List<Long>.lowerBound(value: Long): Long {
    var left = 0L
    var right = this.size.toLong()

    while (left <= right) {
        val mid = (left + right) / 2
        if (this[mid.toInt()] < value) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}

/**
 * 二分探索 upperBound
 * 二分探索でvalueより大きい値が現れる最初の位置を求める
 *
 * @param value 検索する値
 * @return valueより大きい値が現れる最初の位置
 */
private fun List<Int>.upperBound(value: Int): Int {
    var left = 0
    var right = this.size

    while (left <= right) {
        val mid = (left + right) / 2
        if (this[mid] <= value) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}

/**
 * 二分探索 upperBound
 * 二分探索でvalueより大きい値が現れる最初の位置を求める
 *
 * @param value 検索する値
 * @return valueより大きい値が現れる最初の位置
 */
private fun List<Long>.upperBound(value: Long): Long {
    var left = 0L
    var right = this.size.toLong()

    while (left <= right) {
        val mid = (left + right) / 2
        if (this[mid.toInt()] <= value) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}
