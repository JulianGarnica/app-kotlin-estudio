package com.example.estudiouni

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat


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
        val lsFonts = findViewById<Spinner>(R.id.lsFonts)
        val btnAccion = findViewById<Button>(R.id.btnAccion)

        // Fonts
        val faceMadimione = ResourcesCompat.getFont(this, R.font.madimione_regular);
        val faceOjuju = ResourcesCompat.getFont(this, R.font.ojuju_variablefont_wght);
        val faceSlackSideOne = ResourcesCompat.getFont(this, R.font.slacksideone_regular);

        val opcionesFonts = arrayOf("madimione_regular", "ojuju_variablefont_wght", "slacksideone_regular")
        val opciones = arrayOf("Rojo", "Azul", "Verde", "Rosado")

        //"Adapta" el arreglo de datos a los spinner item
        val adaptadorFonts = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesFonts)
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones)
        //Cambia el adaptador del spinner con el que creamos
        lsDatos.adapter = adaptador
        lsFonts.adapter = adaptadorFonts



        lsFonts?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val op = lsFonts.selectedItem.toString()
                when(op.lowercase()) {
                    "madimione_regular" -> {
                        txtLista.typeface = faceMadimione
                    }
                    "ojuju_variablefont_wght" -> {
                        txtLista.typeface = faceOjuju
                    }
                    "slacksideone_regular" -> {
                        txtLista.typeface = faceSlackSideOne
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?){

            }
        }

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