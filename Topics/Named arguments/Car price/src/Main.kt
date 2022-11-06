const val DEFAULT_PRICE = 20_000
const val YEARLY_PRICE_DECREASE = 2000
const val DEFAULT_MAX_SPEED = 120
const val SPEED_PRICE_CHANGE = 100
const val KM_PER_DECREASE = 10_000
const val KM_PRICE_DECREASE = 200
const val AUTOMATIC_PRICE_INCREASE = 1500

fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false) {
    val ageModifier = old * YEARLY_PRICE_DECREASE
    val speedModifier = (maximumSpeed - DEFAULT_MAX_SPEED) * SPEED_PRICE_CHANGE
    val kmModifier = kilometers / KM_PER_DECREASE * KM_PRICE_DECREASE
    val gearModifier = if (automatic) AUTOMATIC_PRICE_INCREASE else 0
    print(DEFAULT_PRICE - ageModifier + speedModifier - kmModifier + gearModifier)
}