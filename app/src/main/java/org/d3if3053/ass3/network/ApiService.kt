package org.d3if3053.ass3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import org.d3if3053.ass3.ui.model.MessageResponse
import org.d3if3053.ass3.ui.model.Outfit
import org.d3if3053.ass3.ui.model.OutfitCreate
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://galerioutfits.vercel.app/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UserApi {
    @POST("outfits/")
    suspend fun addOutfit(
        @Body outfit: OutfitCreate
    ): MessageResponse

    @GET("outfits/")
    suspend fun getAllOutfit(
        @Query("user_email") email: String,
    ): List<Outfit>

    @DELETE("outfits/{outfit_id}")
    suspend fun deleteOutfit(
        @Path("outfit_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}


object Api {
    val userService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

}

enum class ApiStatus { LOADING, SUCCESS, FAILED }