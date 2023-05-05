package chap02

fun main() {
    val n = readInt()
    val a = readIntList()
    val q = readInt()

//    val ruisekiwa = a.scan(0) { acc, x -> acc + x }
    val ruisekiwa = mutableListOf(0)
    for (i in 0 until a.size) {
        if (i == 0) {
            ruisekiwa.add(a[i])
            continue
        }
        ruisekiwa.add(ruisekiwa[i]+a[i])
    }


    repeat(q) {
        val (l, r) = readIntList()
        val count = ruisekiwa[r] - ruisekiwa[l-1]
        when {
            count*2 > r-(l-1) -> println("win")
            count*2 == r-(l-1) -> println("draw")
            else -> println("lose")
        }
    }

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

