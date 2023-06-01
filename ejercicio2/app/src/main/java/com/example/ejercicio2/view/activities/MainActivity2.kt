package com.example.ejercicio2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ejercicio2.R

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val botonuno = findViewById<Button>(R.id.btnuno)
        botonuno.setOnClickListener{
            val lanzar = Intent(this, MainActivity::class.java)
            startActivity(lanzar)
        }

    }
}