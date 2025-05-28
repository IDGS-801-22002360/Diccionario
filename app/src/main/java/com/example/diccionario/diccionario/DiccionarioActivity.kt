package com.example.diccionario.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diccionario.R

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diccionario)

        val btnGuardar = findViewById<Button>(R.id.button)
        btnGuardar.setOnClickListener {
            val intent = Intent(this, GuardarPalActivity::class.java)
            startActivity(intent)
        }

        val btnBuscar = findViewById<Button>(R.id.button2)
        btnBuscar.setOnClickListener {
            val intent = Intent(this, BuscarPalActivity::class.java)
            startActivity(intent)
        }
    }
}