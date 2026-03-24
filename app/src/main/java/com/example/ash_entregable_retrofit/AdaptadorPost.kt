package com.example.ash_entregable_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorPost(private val lista: List<ModeloPost>) : RecyclerView.Adapter<AdaptadorPost.VistaPost>() {

    class VistaPost(vista: View) : RecyclerView.ViewHolder(vista) {
        val textoTitulo: TextView = vista.findViewById(R.id.textoTitulo)
        val textoCuerpo: TextView = vista.findViewById(R.id.textoCuerpo)
    }

    override fun onCreateViewHolder(padre: ViewGroup, tipoClase: Int): VistaPost {
        val vista = LayoutInflater.from(padre.context).inflate(R.layout.item_post, padre, false)
        return VistaPost(vista)
    }

    override fun onBindViewHolder(soporte: VistaPost, posicion: Int) {
        val post = lista[posicion]
        soporte.textoTitulo.text = post.title
        soporte.textoCuerpo.text = post.body
    }

    override fun getItemCount(): Int = lista.size
}
