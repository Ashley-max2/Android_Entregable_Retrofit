package com.example.ash_entregable_retrofit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActividadDos : AppCompatActivity() {

    private lateinit var recicladorComentarios: RecyclerView
    private lateinit var entradaNumeroId: EditText
    private lateinit var botonBuscarPost: Button
    private lateinit var textoInfoPost: TextView

    override fun onCreate(estado: Bundle?) {
        super.onCreate(estado)
        setContentView(R.layout.activity_actividad_dos)

        recicladorComentarios = findViewById(R.id.recicladorComentarios)
        entradaNumeroId = findViewById(R.id.entradaNumeroId)
        botonBuscarPost = findViewById(R.id.botonBuscarPost)
        textoInfoPost = findViewById(R.id.textoInfoPost)

        recicladorComentarios.layoutManager = LinearLayoutManager(this)

        botonBuscarPost.setOnClickListener {
            val textoId = entradaNumeroId.text.toString()
            if (textoId.isNotEmpty()) {
                val idEntero = textoId.toIntOrNull()
                if (idEntero != null) {
                    cargarPost(idEntero)
                    cargarComentarios(idEntero)
                }
            }
        }
    }

    private fun cargarPost(idEntero: Int) {
        ClienteRetrofit.instancia.obtenerPost(idEntero).enqueue(object : Callback<ModeloPost> {
            override fun onResponse(llamada: Call<ModeloPost>, respuesta: Response<ModeloPost>) {
                if (respuesta.isSuccessful) {
                    val cuerpo = respuesta.body()
                    if (cuerpo != null) {
                        textoInfoPost.text = cuerpo.title + "\n\n" + cuerpo.body
                    }
                }
            }

            override fun onFailure(llamada: Call<ModeloPost>, error: Throwable) {
                Toast.makeText(this@ActividadDos, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun cargarComentarios(idEntero: Int) {
        ClienteRetrofit.instancia.obtenerComentariosPorPost(idEntero).enqueue(object : Callback<List<ModeloComentario>> {
            override fun onResponse(llamada: Call<List<ModeloComentario>>, respuesta: Response<List<ModeloComentario>>) {
                if (respuesta.isSuccessful) {
                    val cuerpo = respuesta.body()
                    if (cuerpo != null) {
                        val adaptador = AdaptadorComentario(cuerpo)
                        recicladorComentarios.adapter = adaptador
                    }
                }
            }

            override fun onFailure(llamada: Call<List<ModeloComentario>>, error: Throwable) {
                Toast.makeText(this@ActividadDos, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
