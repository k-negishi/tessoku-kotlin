package chap02

//https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_cg
fun main() {
    val n = readInt()
    val s = MutableList(1509) { MutableList(1509) { 0 } }

    // 各座標にある点の数を求める
    repeat(n) {
        val (x,y) = readIntList()
        s[x][y]++
    }
    val q = readInt()

    val t = MutableList(1509) { MutableList(1509) { 0 } }

    // 横の累積和を取る
    for (i in 1 .. 1500) {
        for (j in 1 .. 1500) {
            t[i][j] = t[i][j-1] + s[i][j]
        }
    }

    // 縦の累積和を取る
    for (i in 1 .. 1500) {
        for (j in 1..1500) {
            t[i][j] += t[i-1][j]
        }
    }

    // 答えを求める
    repeat(q) {
        val (a, b, c, d) = readIntList()
        val ans = t[c][d] + t[a-1][b-1] - t[a-1][d] - t[c][b-1]
        println(ans)
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

