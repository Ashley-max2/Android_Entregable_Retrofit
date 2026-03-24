package com.example.ash_entregable_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClienteRetrofit {
    private const val URL_BASE = "https://jsonplaceholder.typicode.com/"

    val instancia: ServicioApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ServicioApi::class.java)
    }
}
