package chap01

// TODO
fun main() {
    val (n, k) = readIntList()
    var count = 0

    for (i in 1 .. n) {
        for (j in 1 .. n ) {
            val x = k - i - j
            if (x in 1..n) {
                count++
            }
        }
    }
    println(count)

//    for (i in 1 .. n) {
//        for (j in 1 .. n) {
//            for (l in 1 .. n) {
//                if (i + j + l == k) {
//                    count++
//                    break
//                }
//                if (i + k + j < k) {
//                    break
//                }
//            }
//        }
//    }
//    println(count)

}


private fun read() = readLine()!!

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

