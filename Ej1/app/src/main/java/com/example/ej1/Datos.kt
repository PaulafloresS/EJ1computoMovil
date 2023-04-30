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



        //calculando el zodiaco
        fun zodiaco(day: Int, month: Int) {
            when {
                (month == 1 && day >= 20 || month == 2 && day <= 19) -> {
                    binding.tvZodiacal.text ="@string/acuario"
                    binding.ivZodiaco.setImageResource(R.drawable.acuario)
                }
                (month == 2 && day >= 20 || month == 3 && day <= 20) -> {
                    binding.tvZodiacal.text ="@string/picis"
                    binding.ivZodiaco.setImageResource(R.drawable.piscis)
                }
                (month == 12 && day >= 22 || month == 1 && day <= 19) -> {
                    binding.tvZodiacal.text ="@string/capricornio"
                    binding.ivZodiaco.setImageResource(R.drawable.capricornio)
                }
                (month == 11 && day >= 23 || month == 12 && day <= 21) -> {
                    binding.tvZodiacal.text ="@string/sagitario"
                    binding.ivZodiaco.setImageResource(R.drawable.sagitario)
                }
                (month == 10 && day >= 23 || month == 11 && day <= 22) -> {
                    binding.tvZodiacal.text ="@string/escorpion"
                    binding.ivZodiaco.setImageResource(R.drawable.escorpio)
                }
                (month == 9 && day >= 23 || month == 10 && day <= 22) -> {
                    binding.tvZodiacal.text ="@string/libra"
                    binding.ivZodiaco.setImageResource(R.drawable.libra)
                }
                (month == 8 && day >= 23 || month == 9 && day <= 22) -> {
                    binding.tvZodiacal.text ="@string/virgo"
                    binding.ivZodiaco.setImageResource(R.drawable.virgo)
                }
                (month == 7 && day >= 23 || month == 8 && day <= 22) -> {
                    binding.tvZodiacal.text ="@string/leo"
                    binding.ivZodiaco.setImageResource(R.drawable.leo)
                }
                (month == 6 && day >= 21 || month == 7 && day <= 22) -> {
                    binding.tvZodiacal.text ="@string/cancer"
                    binding.ivZodiaco.setImageResource(R.drawable.cancer)
                }
                (month == 5 && day >= 21 || month == 6 && day <= 20) -> {
                    binding.tvZodiacal.text ="@string/geminis"
                    binding.ivZodiaco.setImageResource(R.drawable.geminis)
                }
                (month == 4 && day >= 21 || month == 5 && day <= 20) -> {
                    binding.tvZodiacal.text ="@string/tauro"
                    binding.ivZodiaco.setImageResource(R.drawable.tauro)
                }
                (month == 3 && day >= 21 || month == 4 && day <= 20) -> {
                    binding.tvZodiacal.text ="@string/aries"
                    binding.ivZodiaco.setImageResource(R.drawable.aries)
                }
                else -> "Input invalido"
            }
        }


    }

}