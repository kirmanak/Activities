package page.kirmanak.activities

data class BoredActivityResponse(
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants: Int,
    val price: Double,
    val key: String
)
