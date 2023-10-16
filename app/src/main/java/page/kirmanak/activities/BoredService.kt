package page.kirmanak.activities

import retrofit2.http.GET
import retrofit2.http.Query

interface BoredService {

    @GET("/api/activity/")
    suspend fun getActivity(
        @Query("type") type: String?,
        @Query("participants") participants: Int?,
    ) : BoredActivityResponse

     //  public BoredActivityResponse getActivity(String type, int participants)
}