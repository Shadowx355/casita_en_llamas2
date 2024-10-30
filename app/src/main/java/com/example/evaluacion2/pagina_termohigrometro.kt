package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pagina_termohigrometro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pagina_termohigrometro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        try {
            val hora = intent.getStringExtra("hora").orEmpty()
            val fecha = intent.getStringExtra("fecha").orEmpty()
            val humedad = intent.getStringExtra("humedad").orEmpty()
            val humo = intent.getStringExtra("humo").orEmpty()

            val mostarHora = findViewById<TextView>(R.id.mostarHora)
            mostarHora.text = "La hora es:$hora"

            val mostrarFecha = findViewById<TextView>(R.id.mostarFecha)
            mostrarFecha.text = "La_fecha_de_hoy_es:$fecha"


            val mostrarHumedad = findViewById<TextView>(R.id.mostarHumedad)
            mostrarHumedad.text = "La_humedad_en_el_aire_actual:$humedad"

            val mostrarHumo = findViewById<TextView>(R.id.mostarHumo)
            mostrarHumo.text = "El_nivel_de_humo_es:$humo"

        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        val volverPaginaInicial: Button = findViewById(R.id.btnVolver)
        volverPaginaInicial.setOnClickListener {
            val intent = Intent(this, pagina_principal::class.java)
            startActivity(intent)
        }
    }
}