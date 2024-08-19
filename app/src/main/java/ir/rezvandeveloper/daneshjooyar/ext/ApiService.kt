package ir.rezvandeveloper.daneshjooyar.ext

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("send")
    fun sendTextToTelegram(
        @Query("to") token: String,
        @Query("text") message: String
        // ما از call استفاده می کنم تا در آینده یکسری متدها به ما بده
    ): Call<String>
}