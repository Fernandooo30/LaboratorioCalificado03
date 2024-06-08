package com.fernando.mendoza.laboratoriocalificado03.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://private-effe28-tecsup1.apiary-mock.com"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    val apiService: ApiService
        get() = retrofitInstance!!.create(ApiService::class.java)
}
