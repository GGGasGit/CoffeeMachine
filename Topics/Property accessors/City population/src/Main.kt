const val MAX_POPULATION = 50_000_000

data class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = if (value < 0) {
                0
            } else if (value > MAX_POPULATION) {
                MAX_POPULATION
            } else {
                value
            }
        }
}