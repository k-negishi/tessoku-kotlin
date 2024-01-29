package chap03

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_cm
fun main() {
    val (n, k) = readIntList()
    val a = readIntList()

    if (n == 1) {
        if (a.first() == k) println("Yes") else println("No")
        return
    }

    val p = a.subList(0, n / 2)
    val q = a.subList(n / 2, n)

    val pSet = mutableSetOf<Long>()
    val qSet = mutableSetOf<Long>()

    // ビット全探索
    for (i in 0 until (1 shl (n / 2))) {
        var sum = 0L
        for (j in 0 until (n / 2)) {
            if (i.shr(j) % 2 == 1) {
                sum += p[j]
            }
        }
        pSet.add(sum)
    }

    for (i in 0 until (1 shl (n / 2))) {
        var sum = 0L
        for (j in 0 until n / 2) {
            if (i.shr(j) % 2 == 1) {
                sum += q[j]
            }
        }
        qSet.add(sum)
    }

    pSet.forEach { it ->
        val x = k - it
        if (qSet.contains(x)) {
            println("Yes")
            return
        }
    }

    println("No")
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

private fun List<Int>.lowerBound(value: Int): Int {
    var left = 0
    var right = this.size

    while (left < right) {
        val mid = left + (right - left) / 2
        if (this[mid] < value) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return left
}

