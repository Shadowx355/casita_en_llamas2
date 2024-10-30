package com.example.evaluacion2

import android.content.Context
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

class registro_app : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_app)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre: EditText = findViewById(R.id.etNombre)
        val etContrasena: EditText = findViewById(R.id.etContrasena)

        val RegistrarDatos: Button = findViewById(R.id.btnRegistro)
        RegistrarDatos.setOnClickListener {

            val nombre = etNombre.text.toString()
            val contrasena = etContrasena.text.toString()

            if (nombre.isEmpty() || contrasena.isEmpty()) {

                Toast.makeText(this, "Ingresa los datos amigo mio", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val pref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("username", nombre)
                    editor.putString("password", contrasena)
                    editor.apply()

                    Toast.makeText(this, "El usuario se ah creado correctamente felicidades", Toast.LENGTH_LONG).show()

                    etNombre.setText("")
                    etContrasena.setText("")

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } catch (e: Exception) {
                    Log.e("Error", e.message.toString())
                }
            }
        }


        val IniciarSesions: Button = findViewById(R.id.btnSesion)
        IniciarSesions.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
