package page.kirmanak.activities

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class BoredRepositoryImpl : BoredRepository {

    private val service: BoredService

    init {
        val contentType = "application/json".toMediaType()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()

        service = retrofit.create(BoredService::class.java)
    }

    override suspend fun getActivity(type: String?, participants: Int?): BoredActivityResponse {
        return service.getActivity(type, participants)
    }
}