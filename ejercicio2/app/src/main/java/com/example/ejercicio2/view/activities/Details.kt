package com.example.ejercicio2.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.ActivityDetailsBinding
import com.example.ejercicio2.model.EstudianteDetail
import com.example.ejercicio2.network.HarryApi
import com.example.ejercicio2.network.RetrofitService
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

        call.enqueue(object : Callback<EstudianteDetail> {
            override fun onResponse(
                call: Call<EstudianteDetail>,
                response: Response<EstudianteDetail>
            ) {
                binding.tvtitle.text = response.body()!!.title
                binding.tvBirth.text = response.body()!!.birth
                binding.tvid.text = response.body()!!.id
                binding.tvEyecoulor.text = response.body()!!.eyeColour
                binding.tvhairCoulor.text = response.body()!!.hairColour
                binding.tvHouse.text= response.body()!!.house
                binding.tvancestry.text = response.body()!!.ancestry
                binding.tvpatronus.text = response.body()!!.patronus

                Glide.with(this@Details)
                    .load(response.body()!!.image)
                    .into(binding.ivcaracteristicas)
            }

            override fun onFailure(call: Call<EstudianteDetail>, t: Throwable) {
                Toast.makeText(this@Details, "No hay conexión", Toast.LENGTH_SHORT).show()
            }

        })

    }
}