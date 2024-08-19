package ir.rezvandeveloper.daneshjooyar.ext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository private constructor() {

    companion object {

        private var apiRepository: ApiRepository? = null

        // singleton pattern: یکبار از ApiRepository آبجکت ایجاد می کند .
        val instance: ApiRepository
            get() {
                if (apiRepository == null) apiRepository = ApiRepository()
                return apiRepository!!
            }

        // یا این متد یا متد بالا لازم است
        /*fun getInstance(): ApiRepository {
            if (apiRepository == null) apiRepository = ApiRepository()
            return apiRepository!!
        }*/

        fun sendText(to: String, text: String) {
            RetrofitService.apiService.sendTextToTelegram(to, text).enqueue(
                object: Callback<String>{
                    override fun onResponse(call: Call<String>, response: Response<String>) {

                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {

                    }
                }
            )
        }
    }
}