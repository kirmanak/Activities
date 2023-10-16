package page.kirmanak.activities

interface BoredRepository {

    suspend fun getActivity(
        type: String?,
        participants: Int?,
    ) : BoredActivityResponse
}