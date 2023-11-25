package chap02

// https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_h
fun main() {
    val (h, w) = readIntList()
    val x = MutableList(h+1) { MutableList(w+1) { 0 } }

    for (i in 1 .. h) {
        val int = readIntList()
        for (j in 1 .. w) {
            x[i][j] = int[j-1]
        }
    }

    val q = readInt()

    val acc = MutableList(h+1) { MutableList(w+1) { 0 } }

    // 横方向に累積和を取る
    for (i in 1 .. h) {
        for (j in 1 .. w) {
            acc[i][j] = acc[i][j-1] + x[i][j]
        }
    }

    // 縦方向に累積和を取る
    for (i in 1 .. h) {
        for (j in 1 .. w) {
            acc[i][j] = acc[i-1][j] + acc[i][j]
        }
    }

    // 答えを求める
    repeat(q) {
        val (a, b, c, d) = readIntList()
        val ans = acc[c][d] + acc[a-1][b-1] - acc[a-1][d] - acc[c][b-1]
        println(ans)
    }

//    val acc = MutableList(h) { MutableList(w) { 0 } }
//
//    for (i in 0 until h) {
//        var last = 0
//        for (j in 0 until w) {
//            if (i == 0 && j == 0) {
//                acc[i][j] = x[i][j]
//            } else if (j == 0) {
//                acc[i][j] = last + x[i - 1][w - 1]
//            } else {
//                acc[i][j] = last + x[i][j]
//            }
//            last = acc[i][j]
//        }
//    }
//
//    repeat(q) {
//        val (a, b, c, d) = readIntList()
//            for (i in 0 until h) {
//                for (j in 0 until w) {
//                    if (i < a || (i == a && j < b)) {
//                        continue
//                    }
//
//                }
//            }
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

