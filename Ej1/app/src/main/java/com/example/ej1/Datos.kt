package com.example.ej1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        var mes = intent.getIntExtra("mes",0)
        val year = intent.getIntExtra("anio",0)
        val dia = intent.getIntExtra("dia",0)

        mes=mes+1
        binding.idtvCorreo.text = email
        binding.idtvNumCuenta.text = numCuenta
        binding.idtvEdad.text = age
        binding.idtvApellido.text = nombre
        binding.idtvNombre.text = apellido
        Log.d("fecha","${mes}"+" "+" "+"${dia}")
       zodiaco(dia,mes)

    }

    private  fun zodiaco(dia: Int, mes: Int) {
        when {
            (mes == 1 && dia >= 20 || mes == 2 && dia <= 19) -> {
                binding.tvZodiacal.text = "@string/acuario"
                binding.ivZodiaco.setImageResource(R.drawable.acuario)
            }

            (mes == 2 && dia >= 19 || mes == 3 && dia <= 20) -> {
                binding.tvZodiacal.text = "Picis"
                binding.ivZodiaco.setImageResource(R.drawable.piscis)
            }

            (mes == 12 && dia >= 22 || mes == 1 && dia <= 19) -> {
                binding.tvZodiacal.text = "Capricornio"
                binding.ivZodiaco.setImageResource(R.drawable.capricornio)
            }

            (mes == 11 && dia >= 22 || mes == 12 && dia <= 21) -> {
                binding.tvZodiacal.text = "Sagitario"
                binding.ivZodiaco.setImageResource(R.drawable.sagitario)
            }

            (mes == 10 && dia >= 23 || mes == 11 && dia <= 21) -> {
                binding.tvZodiacal.text = "Escorpion"
                binding.ivZodiaco.setImageResource(R.drawable.escorpio)
            }

            (mes == 9 && dia >= 23 || mes == 10 && dia <= 22) -> {
                binding.tvZodiacal.text = "Libra"
                binding.ivZodiaco.setImageResource(R.drawable.libra)
            }

            (mes == 8 && dia >= 23 || mes == 9 && dia <= 22) -> {
                binding.tvZodiacal.text = "Virgo"
                binding.ivZodiaco.setImageResource(R.drawable.virgo)
            }

            (mes == 7 && dia >= 23 || mes == 8 && dia <= 22) -> {
                binding.tvZodiacal.text = "Leo"
                binding.ivZodiaco.setImageResource(R.drawable.leo)
            }

            (mes == 6 && dia >= 21 || mes == 7 && dia <= 22) -> {
                binding.tvZodiacal.text = "Cancer"
                binding.ivZodiaco.setImageResource(R.drawable.cancer)
            }

            (mes == 5 && dia >= 21 || mes == 6 && dia <= 20) -> {
                binding.tvZodiacal.text = "Geminis"
                binding.ivZodiaco.setImageResource(R.drawable.geminis)
            }

            (mes == 4 && dia >= 20|| mes == 5 && dia <= 20) -> {
                binding.tvZodiacal.text = "Tauro"
                binding.ivZodiaco.setImageResource(R.drawable.tauro)
            }

            (mes == 3 && dia >= 21 || mes == 4 && dia <= 19) -> {
                binding.tvZodiacal.text = "Aries"
                binding.ivZodiaco.setImageResource(R.drawable.aries)
            }

            else -> "Input invalido"
        }

    }

}