package com.example.ash_entregable_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicioApi {

    @GET("posts")
    fun obtenerPosts(): Call<List<ModeloPost>>

    @GET("posts/{id}")
    fun obtenerPost(@Path("id") id: Int): Call<ModeloPost>

    @GET("comments")
    fun obtenerComentariosPorPost(@Query("postId") postId: Int): Call<List<ModeloComentario>>
}
