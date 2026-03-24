package com.example.ash_entregable_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorComentario(private val lista: List<ModeloComentario>) : RecyclerView.Adapter<AdaptadorComentario.VistaComentario>() {

    class VistaComentario(vista: View) : RecyclerView.ViewHolder(vista) {
        val textoNombre: TextView = vista.findViewById(R.id.textoNombre)
        val textoEmail: TextView = vista.findViewById(R.id.textoEmail)
        val textoCuerpo: TextView = vista.findViewById(R.id.textoCuerpo)
    }

    override fun onCreateViewHolder(padre: ViewGroup, tipoClase: Int): VistaComentario {
        val vista = LayoutInflater.from(padre.context).inflate(R.layout.item_comentario, padre, false)
        return VistaComentario(vista)
    }

    override fun onBindViewHolder(soporte: VistaComentario, posicion: Int) {
        val comentario = lista[posicion]
        soporte.textoNombre.text = comentario.name
        soporte.textoEmail.text = comentario.email
        soporte.textoCuerpo.text = comentario.body
    }

    override fun getItemCount(): Int = lista.size
}
