fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

const val LOWER_LIMIT = -128
const val UPPER_LIMIT = 127

class ByteTimer(var time: Int) {
    init {
        time = if (time < LOWER_LIMIT) {
            LOWER_LIMIT
        } else if (time > UPPER_LIMIT) {
            UPPER_LIMIT
        } else {
            time
        }
    }
}