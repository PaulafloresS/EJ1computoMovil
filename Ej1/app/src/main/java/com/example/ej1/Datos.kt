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
        var mes = intent.getIntExtra("mes", 0)
        val year = intent.getIntExtra("anio", 0)
        val dia = intent.getIntExtra("dia", 0)
        val carrera = bundle?.getString("carrera", "")


        mes = mes + 1
        binding.idtvCorreo.text = email
        binding.idtvNumCuenta.text = numCuenta
        binding.idtvEdad.text = age
        binding.idtvApellido.text = nombre
        binding.idtvNombre.text = apellido

        //sppinner


        Log.d("fecha","${mes}"+" "+" "+"${dia}")
       zodiaco(dia,mes)

        //calculando el horoscopo chino
        if(year==1936 || year==1948 || year==1960 || year==1972 ||year==1984 ||year==1996 || year==2008){
            binding.tvChino.text= "rata"
            binding.ivchino.setImageResource(R.drawable.rata)
        }
        if(year==1937 || year==1949 ||year==1961 || year==1973 || year==1985 || year==1997 || year==2009){
            binding.tvChino.text= "buey"
            binding.ivchino.setImageResource(R.drawable.buey)
        }
        if(year==1938|| year==1950|| year== 1962 || year==1974 || year==1986 || year==1998 || year==2010){
            binding.tvChino.text= "Tigre"
            binding.ivchino.setImageResource(R.drawable.tigre)
        }
        if(year==1939 || year==1951 || year==1963 || year==1975 || year==1987 || year==1999 || year==2011) {
            binding.tvChino.text = "Conejo"
            binding.ivchino.setImageResource(R.drawable.conejo)
        }
        if(year==1940 || year==1952 || year==1964 || year==1988 ||year==2000|| year===2012 || year==2011){
            binding.tvChino.text = "Dragon"
            binding.ivchino.setImageResource(R.drawable.dragon)
        }
        if(year==1941 || year==1953 || year==1965 || year==1977 ||year==1989|| year===2001 || year==2013){
            binding.tvChino.text = "Serpiente"
            binding.ivchino.setImageResource(R.drawable.serpiente)
        }
        if(year==1942 || year==1954 || year==1966 || year==1978 ||year==1990|| year===2002 || year==2014){
            binding.tvChino.text = "Caballo"
            binding.ivchino.setImageResource(R.drawable.caballo)
        }
        if(year==1943 || year==1955 || year==1967 || year==1979 ||year==1991|| year===2003 || year==2015){
            binding.tvChino.text = "Cabra"
            binding.ivchino.setImageResource(R.drawable.cabra)
        }
        if(year==1944 || year==1956 || year==1968 || year==1980 ||year==1992|| year===2004 || year==2016){
            binding.tvChino.text = "Mono"
            binding.ivchino.setImageResource(R.drawable.mono)
        }
        if(year==1945 || year==1957 || year==1969 || year==1981 ||year==1993|| year===2005 || year==2017){
            binding.tvChino.text = "Gallo"
            binding.ivchino.setImageResource(R.drawable.gallo)
        }
        if(year==1946 || year==1958 || year==1970 || year==1982 ||year==1994|| year===2006 || year==2018){
            binding.tvChino.text = "Perro"
            binding.ivchino.setImageResource(R.drawable.perro)
        }
        if(year==1947 || year==1959 || year==1971 || year==1983 ||year==1995|| year===2007 || year==2019){
            binding.tvChino.text = "Cerdo"
            binding.ivchino.setImageResource(R.drawable.cerdo)
        }

    }
    //funcion para las carreras




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