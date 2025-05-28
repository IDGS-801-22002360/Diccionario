package com.example.diccionario.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diccionario.R

class BuscarPalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_pal)

        val radioEsp = findViewById<RadioButton>(R.id.radioButton)
        val radioIng = findViewById<RadioButton>(R.id.radioButton2)
        val editTextBuscar = findViewById<EditText>(R.id.editTextText4)
        val txtResultado = findViewById<TextView>(R.id.txtPalabraEncontrada)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnMenu = findViewById<Button>(R.id.btnMenu1)

        btnBuscar.setOnClickListener {
            val buscar = editTextBuscar.text.toString().trim().lowercase()
            val resultado = buscarPalabra(buscar, radioEsp.isChecked)
            txtResultado.text = resultado
        }

        btnMenu.setOnClickListener {
            finish()
        }
    }

    // busca en el archivo según el idioma seleccionado
    private fun buscarPalabra(palabra: String, esEspanol: Boolean): String {
        val fileInput = try { openFileInput("diccionario.txt") } catch (e: Exception) { null }
        if (fileInput == null) return "No hay diccionario"

        fileInput.bufferedReader().useLines { lines ->
            lines.forEach { linea ->
                val partes = linea.split(",")
                if (partes.size == 2) {
                    val esp = partes[0].trim().lowercase()
                    val ing = partes[1].trim().lowercase()
                    if (esEspanol && palabra == ing) return esp
                    if (!esEspanol && palabra == esp) return ing
                }
            }
        }
        return "Palabra no encontrada"
    }
}