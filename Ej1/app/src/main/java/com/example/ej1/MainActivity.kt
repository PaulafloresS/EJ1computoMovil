package com.example.ej1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ej1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun click(view: View) {

       if(binding.etNombre.text.isEmpty()){
            binding.etNombre.error= R.string.valor_requerido.toString()
           Toast.makeText(this, getString(R.string.ingresa_valor), Toast.LENGTH_LONG).show()
        }


        if(binding.etApellido.text.isEmpty()){
            binding.etApellido.error= R.string.valor_requerido.toString()
            Toast.makeText(this, getString(R.string.ingresa_valor), Toast.LENGTH_LONG).show()
        }

        if(binding.etEmail.text.isEmpty()){
            binding.etEmail.error= R.string.valor_requerido.toString()
            Toast.makeText(this, getString(R.string.ingresa_valor), Toast.LENGTH_LONG).show()
        }

    }
}