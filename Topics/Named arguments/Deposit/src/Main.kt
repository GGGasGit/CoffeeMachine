import kotlin.math.pow

const val PERCENT = 100

fun main() {

    fun depositCalculator(amount: Int = 1000, percent: Int = 5, years: Int = 10) {
        print((amount * (1 + percent.toDouble() / PERCENT).pow(years)).toInt())
    }

    val parameter = readln()
    val value = readln().toInt()

    when (parameter) {
        "amount" -> depositCalculator(amount = value)
        "percent" -> depositCalculator(percent = value)
        "years" -> depositCalculator(years = value)
        else -> print("Wrong parameter received")
    }

}