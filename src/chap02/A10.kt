package chap02

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_j
fun main() {
    val n = readInt()
    val a = readIntList()
    val d = readInt()

    val maxL = MutableList(n) { 0 }
    maxL[0] = a[0]

    for (i in 1 until n) {
        maxL[i] = a[i].coerceAtLeast(maxL[i - 1])
    }

    val maxR = MutableList(n) { 0 }
    maxR[n-1] = a[n-1]

    for (i in n-2 downTo 0) {
        maxR[i] = a[i].coerceAtLeast(maxR[i + 1])
    }

    repeat(d) {
        val (l, r) = readIntList()
        println(Math.max(maxL[l-2], maxR[r]))
    }

    // 累積和を使わない解法はTLE
//    repeat(d) {
//        val(l, r) = readIntList()
//        val listL = a.subList(0, l-1)
//        val listR = a.subList(r, n-1)
//        println((listL + listR).max())
//    }
}


private fun read() = readln()

private fun readInt() = read().toInt()

private fun readLong() = read().toLong()

private fun readDouble() = read().toDouble()

private fun readStringList(): MutableList<String> = read().split(" ").toMutableList()

private fun readIntList(): MutableList<Int> = readStringList().map { it.toInt() }.toMutableList()

private fun readLongList(): MutableList<Long> = readStringList().map { it.toLong() }.toMutableList()

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

