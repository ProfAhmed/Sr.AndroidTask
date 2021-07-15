import kotlin.math.pow

fun main(args: Array<String>) {
    //Q I
    val expression1 = (-3 + 1) * (3 - 9)
    val expression2 = (3 * 1).toDouble().pow(0) * (9 + 3)       // (3*1)^0 * (3+9)
    val expression3 = 3 * (1 + 3) * (9).toDouble().pow(0)       //3 * (1+3) * (9)^0
    println(expression1)
    println(expression2)
    println(expression3)

    println(isAnagrams("debit card", "bad credit"))
    println(getFibonacciIterative(10))
    println(getFibonacciRecursive(5))
}

// Q II
fun isAnagrams(str1: String, str2: String): Boolean {
    val str11 = str1.replace("\\s".toRegex(), "").toLowerCase()     //remove spaces
    val str22 = str2.replace("\\s".toRegex(), "").toLowerCase()     //remove spaces
    if (str11.length != str22.length) return false
    val str1Sorted = str11.toCharArray().sorted().toString()
    val str2Sorted = str22.toCharArray().sorted().toString()
    if (str1Sorted != str2Sorted) return false
    return true
}

//Q III
//iterative approach
fun getFibonacciIterative(size: Int): MutableList<Int> {
    val seq = mutableListOf(0)
    if (size == 1) return seq
    seq.add(1)
    for (i in 1 until size - 1) {
        seq.add(seq[seq.lastIndex] + seq[seq.lastIndex - 1]) // add the result of sum every last two indexes
    }
    return seq
}

//recursive approach
fun getFibonacciRecursive(
    count: Int,
    first: Int = 0,
    second: Int = 1,
    result: MutableList<Int> = mutableListOf()
): MutableList<Int> {
    return if (count > 0) {
        result.add(first)
        getFibonacciRecursive(count - 1, second, first + second, result)
    } else {
        result
    }
}

