package com.example.evaluacion2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class configuracion_app : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_app)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val volverInicio: Button = findViewById(R.id.btnVolver)
        volverInicio.setOnClickListener {
            val intent = Intent(this, pagina_principal::class.java)
            startActivity(intent)
        }

        val cerrarSesion: Button = findViewById(R.id.btnVolverSesion)
        cerrarSesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Se ah cerrado la sesion ", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()
        }

        val eliminarCuenta: Button = findViewById(R.id.btnVEliminarCuenta)
        eliminarCuenta.setOnClickListener {
            try {

                val pref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                val editor = pref.edit()


                editor.remove("username")
                editor.remove("password")
                editor.apply()


                Toast.makeText(this, "Tu cuenta se ah borado exitosamente ", Toast.LENGTH_LONG).show()


                val intent = Intent(this, registro_app::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {

                Toast.makeText(this, "No se borro, espera mas tarde.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
