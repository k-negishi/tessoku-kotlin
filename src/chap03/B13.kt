package chap03

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_cl
fun main() {
    val (n, k) = readLongList()
    val N = n.toInt()
    val A = readIntListFromOne()

    val S = LongArray(N + 1) // 累積和
    val R = IntArray(N + 1) // 左端が決まったとき、右端はどこまで行けるか

    for (i in 1..N) {
        S[i] = S[i - 1] + A[i]
    }

    // しゃくとり法
    for (i in 1..N) {
        R[i] = if (i == 1) {
            1
        } else {
            R[i - 1]
        }

        while ((R[i] < n) && (sum(S, i, R[i] + 1) <= k)) {
            R[i]++
        }
    }

    // 答えの計算
    var ans = 0L
    for (i in 1..N) {
        ans += (R[i] - i + 1)
    }
    println(ans)

}

// A[l] から A[r] までの合計値
fun sum(S: LongArray, l: Int, r: Int): Long {
    return S[r] - S[l - 1]
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

