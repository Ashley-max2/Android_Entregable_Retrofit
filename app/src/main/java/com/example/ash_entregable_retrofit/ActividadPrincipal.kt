package com.example.ash_entregable_retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActividadPrincipal : AppCompatActivity() {
    override fun onCreate(estado: Bundle?) {
        super.onCreate(estado)
        setContentView(R.layout.activity_principal)

        findViewById<Button>(R.id.botonAct1).setOnClickListener {
            startActivity(Intent(this, ActividadUno::class.java))
        }

        findViewById<Button>(R.id.botonAct2).setOnClickListener {
            startActivity(Intent(this, ActividadDos::class.java))
        }
    }
}
