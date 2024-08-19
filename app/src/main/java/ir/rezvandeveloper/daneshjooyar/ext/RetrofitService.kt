package ir.rezvandeveloper.daneshjooyar.ext

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {

    private const val url = "https://notificator.ir/api/v1/"
     private val retrofit = Retrofit.Builder()
         .baseUrl(url)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

    val apiService:ApiService = retrofit.create(ApiService::class.java)


}