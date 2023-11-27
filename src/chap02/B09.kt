package chap02

fun main() {
    val n = readInt()
    val acc = MutableList(1509) { MutableList(1509) { 0L } }

    repeat(n) {
        val (a, b, c, d) = readIntList()
        acc[a][b]++
        acc[a][d]--
        acc[c][b]--
        acc[c][d]++
    }

    // 横
    for (i in 0..1500) {
        for (j in 1..1500) {
            acc[i][j] += acc[i][j - 1]
        }
    }

    // 横
    for (i in 1..1500) {
        for (j in 0..1500) {
            acc[i][j] += acc[i - 1][j]
        }
    }

    val ans = acc.sumOf { row -> row.count { it >= 1 } }
    println(ans)
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

