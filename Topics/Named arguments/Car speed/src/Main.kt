fun main(args: Array<String>) {

    fun speedCheck(speed: Int, limit: Int = 60): String {
        return if (speed > limit) "Exceeds the limit by ${speed - limit} kilometers per hour" else "Within the limit"
    }

    val speed = readln().toInt()
    val limit = readln()

    print(if (limit == "no limit") speedCheck(speed = speed) else speedCheck(speed = speed, limit = limit.toInt()))

}