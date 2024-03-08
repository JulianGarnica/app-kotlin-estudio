package com.example.estudiouni

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnCambiar = findViewById<Button>(R.id.btnRegresar)
        btnCambiar.setOnClickListener {
            cambiar()
        }

        val txtLista = findViewById<TextView>(R.id.txtLista)
        val lsDatos = findViewById<Spinner>(R.id.lsDatos)
        val btnAccion = findViewById<Button>(R.id.btnAccion)

        val opciones = arrayOf("Rojo", "Azul", "Verde", "Rosado")
        //"Adapta" el arreglo de datos a los spinner item
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones)
        //Cambia el adaptador del spinner con el que creamos
        lsDatos.adapter = adaptador

        lsDatos?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val op = lsDatos.selectedItem.toString()
                when(op.lowercase()) {
                    "rojo" -> {
                        Toast.makeText(applicationContext, "Color ${op}", Toast.LENGTH_LONG).show()
                        txtLista.setTextColor(Color.parseColor("#E8120C"))
                    }
                    "azul" -> {
                        Toast.makeText(applicationContext, "Color ${op}", Toast.LENGTH_LONG).show()
                        txtLista.setTextColor(Color.parseColor("#919FFF"))
                    }
                    "verde" -> {
                        Toast.makeText(applicationContext, "Color ${op}", Toast.LENGTH_LONG).show()
                        txtLista.setTextColor(Color.parseColor("#84BF2C"))
                    }
                    "rosado" -> {
                        Toast.makeText(applicationContext, "Color ${op}", Toast.LENGTH_LONG).show()
                        txtLista.setTextColor(Color.parseColor("#FF00FF"))
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?){

            }
        }
    }

    fun cambiar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}