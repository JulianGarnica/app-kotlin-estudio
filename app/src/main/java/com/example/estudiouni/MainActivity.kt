package com.example.estudiouni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCambiar = findViewById<Button>(R.id.btnCambiar)
        btnCambiar.setOnClickListener {
            cambiar()
        }
    }

    fun cambiar(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}