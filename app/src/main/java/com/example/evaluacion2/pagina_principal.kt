package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pagina_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pagina_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cambiarAlertas : Button = findViewById(R.id.btnAlertas)
        cambiarAlertas.setOnClickListener {
            val intent = Intent(this,notificacion_alerta::class.java)
            startActivity(intent)
        }

        val IngresarDatos : Button = findViewById(R.id.btnTermohigrometro)
        IngresarDatos.setOnClickListener {
            val intent = Intent(this,ingresar_datos::class.java)
            startActivity(intent)
        }
        val Configuraciones : Button = findViewById(R.id.btnConfiguracion)
        Configuraciones.setOnClickListener {
            val intent = Intent(this,configuracion_app::class.java)
            startActivity(intent)
        }

    }
}