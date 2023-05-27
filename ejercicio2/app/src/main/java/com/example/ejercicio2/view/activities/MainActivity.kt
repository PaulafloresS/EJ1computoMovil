package com.example.ejercicio2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2.databinding.ActivityMainBinding
import com.example.ejercicio2.model.Estudiantes
import com.example.ejercicio2.network.HarryApi
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.utils.Constans
import com.example.ejercicio2.view.adapters.EstudianteAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = intent.extras

        val id = bundle?.getString("id", "")
        val call = RetrofitService.getRetrofit().create(HarryApi::class.java)

            .getEstudiantes("api/characters/students") //Para Apiary
        //.getGames("cm/games/games_list.php") //Para www.serverbpw.com
        call.enqueue(object : Callback<ArrayList<Estudiantes>>{
            override fun onResponse(
                call: Call<ArrayList<Estudiantes>>,
                response: Response<ArrayList<Estudiantes>>
            ) {
                binding.pbconectar.visibility = View.GONE
                Log.i(Constans.LOGTAG, "Respuesta del servidor: ${response.toString()}")
                Log.i(Constans.LOGTAG,"Datos: ${response.body().toString()}")
                binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                //manejar que no sea nulo
                binding.rvMenu.adapter = EstudianteAdapter(this@MainActivity, response.body()!!) { selectedEstudiante: Estudiantes ->
                    estudianteClicked(selectedEstudiante)
                }
            }

            override fun onFailure(call: Call<ArrayList<Estudiantes>>, t: Throwable) {
                binding.pbconectar.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexion",Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun estudianteClicked(estudiantes: Estudiantes) {
      Toast.makeText(this, "Clic en el elemento con títiulo ${estudiantes.name}", Toast.LENGTH_SHORT)
            .show()

        val bundle = Bundle()

        bundle.putString("id", estudiantes.id)

        val intent = Intent(this, Details::class.java)

        intent.putExtras(bundle)

        startActivity(intent)


    }
}
