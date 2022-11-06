const val MOSCOW_AVG = 5
const val HANOI_AVG = 20
const val DUBAI_AVG = 30
const val TEMP_LIMIT_LOW = -92
const val TEMP_LIMIT_HIGH = 57

data class City(val name: String, private val averageTemp: Int) {
    var degrees: Int = 0
        set(value) {
            field = if (value < TEMP_LIMIT_LOW || value > TEMP_LIMIT_HIGH) averageTemp else value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai", DUBAI_AVG)
    firstCity.degrees = first
    val secondCity = City("Moscow", MOSCOW_AVG)
    secondCity.degrees = second
    val thirdCity = City("Hanoi", HANOI_AVG)
    thirdCity.degrees = third

    val coldestTemp = listOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees).minOrNull()
    val coldestCity = listOf(firstCity, secondCity, thirdCity).filter { it.degrees == coldestTemp }
    print(
        if (coldestCity.size > 1) "neither" else coldestCity[0].name
    )
}