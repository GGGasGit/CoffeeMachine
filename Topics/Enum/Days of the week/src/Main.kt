enum class DaysOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

fun main() {
    for (enum in DaysOfTheWeek.values()) {
        println(enum.name)
    }
}