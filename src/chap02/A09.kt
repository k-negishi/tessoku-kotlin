package chap02

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_i
fun main() {
    val (h, w, n) = readIntList()
    val acc = MutableList(1509) {MutableList(1509) {0} }
    val z = MutableList(1509) {MutableList(1509) {0} }


    repeat(n) {
        val(a, b, c, d) = readIntList()
        acc[a][b]++
        acc[a][d+1]--
        acc[c+1][b]--
        acc[c+1][d+1]++
    }

    // 横方向に累積和
    for (i in 1 .. h) {
        for (j in 1 .. w) {
            z[i][j] = z[i][j-1] + acc[i][j]
        }
    }

    // 縦方向に累積和
    for (i in 1 .. h) {
        for (j in 1 .. w) {
            z[i][j] += z[i-1][j]
        }
    }

    for (i in 1 .. h) {
        for (j in 1 .. w) {
            print(z[i][j])
            print(" ")
        }
        println()
    }
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

