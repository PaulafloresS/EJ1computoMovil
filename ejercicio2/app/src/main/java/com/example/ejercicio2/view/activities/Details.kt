package com.example.ejercicio2.view.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.ejercicio2.R
import com.example.ejercicio2.databinding.ActivityDetailsBinding
import com.example.ejercicio2.model.EstudianteDetail
import com.example.ejercicio2.model.Estudiantes
import com.example.ejercicio2.network.HarryApi
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.utils.Constans
import com.example.ejercicio2.view.adapters.EstudianteAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val id = bundle?.getString("id", "")

        val call = RetrofitService.getRetrofit().create(HarryApi::class.java)
            .getEstudianteDetailApiary(id)

        call.enqueue(object : Callback<ArrayList<EstudianteDetail>> {
            override fun onResponse(
                call: Call<ArrayList<EstudianteDetail>>,
                response: Response<ArrayList<EstudianteDetail>>
            ) {
                val estudiante = response.body()!![0]
                binding.tvid.text = estudiante.id
                binding.tvpatronus.text = estudiante.patronus
                binding.tvBirth.text = estudiante.dateOfBirth
                binding.tvHouse.text = estudiante.house
                binding.tvancestry.text = estudiante.ancestry
                binding.tvEyecoulor.text = estudiante.eyeColour
                binding.tvhairCoulor.text = estudiante.hairColour
                binding.tvtitle.text = estudiante.actor
                binding.tvHouse.text = estudiante.house

                Glide.with(this@Details)
                    .load(estudiante.image)
                    .placeholder(R.drawable.sombrero)
                    .into(binding.ivcaracteristicas)

            }

            override fun onFailure(call: Call<ArrayList<EstudianteDetail>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    }

