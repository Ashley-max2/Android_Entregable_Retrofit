package com.example.ash_entregable_retrofit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActividadUno : AppCompatActivity() {

    private lateinit var recicladorPosts: RecyclerView
    private lateinit var entradaNumero: EditText
    private lateinit var botonBuscar: Button

    override fun onCreate(estado: Bundle?) {
        super.onCreate(estado)
        setContentView(R.layout.activity_actividad_uno)

        recicladorPosts = findViewById(R.id.recicladorPosts)
        entradaNumero = findViewById(R.id.entradaNumero)
        botonBuscar = findViewById(R.id.botonBuscar)

        recicladorPosts.layoutManager = LinearLayoutManager(this)

        botonBuscar.setOnClickListener {
            val texto = entradaNumero.text.toString()
            if (texto.isNotEmpty()) {
                ClienteRetrofit.instancia.obtenerPosts().enqueue(object : Callback<List<ModeloPost>> {
                    override fun onResponse(llamada: Call<List<ModeloPost>>, respuesta: Response<List<ModeloPost>>) {
                        if (respuesta.isSuccessful) {
                            val cuerpo = respuesta.body()
                            if (cuerpo != null) {
                                val adaptador = AdaptadorPost(cuerpo)
                                recicladorPosts.adapter = adaptador
                            }
                        }
                    }

                    override fun onFailure(llamada: Call<List<ModeloPost>>, error: Throwable) {
                        Toast.makeText(this@ActividadUno, "Error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}
