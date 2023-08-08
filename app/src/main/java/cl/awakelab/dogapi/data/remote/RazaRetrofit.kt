package cl.awakelab.dogapi.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RazaRetrofit {

    companion object {
        private val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitRaza(): RazaApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(RazaApi::class.java)
        }
    }
}