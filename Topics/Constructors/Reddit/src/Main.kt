data class Site(val address: String, val foundationYear: Int)

const val REDDIT_FOUNDATION_YEAR = 2005

fun makeReddit() = Site("reddit.com", REDDIT_FOUNDATION_YEAR)