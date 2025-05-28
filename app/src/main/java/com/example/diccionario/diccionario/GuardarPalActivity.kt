package com.example.diccionario.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diccionario.R

class GuardarPalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar_pal)

        val edtEspanol = findViewById<EditText>(R.id.edtEspanol)
        val edtIngles = findViewById<EditText>(R.id.edtIngles)
        val btnGuardar = findViewById<Button>(R.id.button3)
        val btnMenu = findViewById<Button>(R.id.button4)

        btnGuardar.setOnClickListener {
            val palabraEspanol = edtEspanol.text.toString().trim()
            val palabraIngles = edtIngles.text.toString().trim()

            if (palabraEspanol.isNotEmpty() && palabraIngles.isNotEmpty()) {
                guardarPalabra(palabraEspanol, palabraIngles)
                Toast.makeText(this, "Palabra almacenada", Toast.LENGTH_SHORT).show()
                edtEspanol.setText("")
                edtIngles.setText("")
            } else {
                Toast.makeText(this, "Llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnMenu.setOnClickListener {
            finish() // Regresa al menú anterior
        }
    }

    private fun guardarPalabra(espanol: String, ingles: String) {
        val par = "$espanol,$ingles"
        val fileOutput = openFileOutput("diccionario.txt", MODE_APPEND)
        fileOutput.write((par + "\n").toByteArray())
        fileOutput.close()
    }
}