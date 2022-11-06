enum class Countries(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar")
}

fun main() {

    fun findCurrency(name: String): String {
        for (country in Countries.values()) {
            if (name == country.name) return country.currency
        }
        return ""
    }

    val (country1, country2) = readln().split(" ")

    print(if (findCurrency(country1) == findCurrency(country2)) "true" else "false")

}