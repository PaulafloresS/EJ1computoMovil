package com.example.ej1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej1.databinding.ActivityDatosBinding
import com.example.ej1.databinding.ActivityMainBinding

class Datos : AppCompatActivity() {
    private lateinit var binding:ActivityDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val email = intent.getStringExtra("email")
        val numCuenta = intent.getStringExtra("num_cuenta")
        val age = intent.getStringExtra("fecha_nac")

        binding.idtvCorreo.text = email
        binding.idtvNumCuenta.text = numCuenta
       binding.idtvEdad.text = age
        binding.idtvApellido.text = nombre
        binding.idtvNombre.text = apellido

    }

}