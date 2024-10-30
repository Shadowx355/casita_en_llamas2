package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ingresar_datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingresar_datos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val enviarDatos: Button = findViewById(R.id.btnEnviarDatos)
        enviarDatos.setOnClickListener {
            try {
                val hora = findViewById<EditText>(R.id.etHora).text.toString()
                val fecha = findViewById<EditText>(R.id.etFecha).text.toString()
                val humedad = findViewById<EditText>(R.id.etHumedad).text.toString()
                val humo = findViewById<EditText>(R.id.etHumo).text.toString()


                if (hora.isNotEmpty() && fecha.isNotEmpty() && humedad.isNotEmpty() && humo.isNotEmpty()) {
                    val intent = Intent(this, pagina_termohigrometro::class.java)
                    intent.putExtra("hora", hora)
                    intent.putExtra("fecha", fecha)
                    intent.putExtra("humedad", humedad)
                    intent.putExtra("humo", humo)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
        val volverPaginaInicial : Button = findViewById(R.id.btnVolverPaginaPrincipal)
        volverPaginaInicial.setOnClickListener {
            val intent = Intent(this,pagina_principal::class.java)
            startActivity(intent)
        }
    }
}