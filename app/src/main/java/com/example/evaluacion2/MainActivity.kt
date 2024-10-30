package com.example.evaluacion2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputNombre = findViewById<EditText>(R.id.inputNombre)
        val inputContrasena = findViewById<EditText>(R.id.inputContrasena)

        val registros: Button = findViewById(R.id.btnVolverRegistro)
        registros.setOnClickListener {
            val intent = Intent(this, registro_app::class.java)
            startActivity(intent)
        }


        val welcomeapp: Button = findViewById(R.id.btnIniciarSesion)
        welcomeapp.setOnClickListener {

            val username = inputNombre.text.toString()
            val password = inputContrasena.text.toString()


            val pref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val savedUsername = pref.getString("username", null)
            val savedPassword = pref.getString("password", null)

            if (username == savedUsername && password == savedPassword) {
                val intent = Intent(this, pagina_principal::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "Has ingresado a la app.", Toast.LENGTH_SHORT).show()
        }
    }
}
