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
                binding.tvpatronus.text = estudiante.patronus
                binding.tvancestry.text = estudiante.ancestry
                binding.tvid.text = estudiante.name
                binding.tvtitle.text = estudiante.actor
                binding.tvpatronus.text = estudiante.patronus
                binding.tvBirth.text = estudiante.dateOfBirth
                binding.tvHouse.text = estudiante.house
                binding.tvEyecoulor.text = estudiante.eyeColour
                binding.tvhairCoulor.text = estudiante.hairColour
                binding.tvHouse.text = estudiante.house

                if( binding.tvid.text.isNullOrEmpty()){
                    binding.tvid.text = getString(R.string.sindato)
                }else{
                    binding.tvid.text = estudiante.name
                }
                if(binding.tvancestry.text.isNullOrEmpty()){
                    binding.tvancestry.text = getString(R.string.sindato)
                }else{
                    binding.tvancestry.text = estudiante.ancestry
                }
                if(binding.tvtitle.text.isNullOrEmpty()){
                    binding.tvtitle.text = getString(R.string.sindato)
                }else{
                    binding.tvtitle.text = estudiante.actor
                }
                if(binding.tvpatronus.text.isNullOrEmpty()){
                    binding.tvpatronus.text = getString(R.string.sindato)
                }else{
                    binding.tvpatronus.text = estudiante.patronus
                }
                if(binding.tvBirth.text.isNullOrEmpty()){
                    binding.tvBirth.text = getString(R.string.sindato)
                }else{
                    binding.tvBirth.text = estudiante.dateOfBirth
                }
                if(binding.tvHouse.text.isNullOrEmpty()){
                    binding.tvHouse.text = getString(R.string.sindato)
                }else{
                    binding.tvHouse.text = estudiante.house
                }
                if(binding.tvEyecoulor.text.isNullOrEmpty()){
                    binding.tvEyecoulor.text = getString(R.string.sindato)
                }else{
                    binding.tvEyecoulor.text = estudiante.eyeColour
                }
                if(binding.tvhairCoulor.text.isNullOrEmpty()){
                    binding.tvhairCoulor.text = getString(R.string.sindato)
                }else{
                    binding.tvhairCoulor.text = estudiante.hairColour
                }
                if(binding.tvHouse.text.isNullOrEmpty()){
                    binding.tvHouse.text = getString(R.string.sindato)
                }else{
                    binding.tvHouse.text = estudiante.house
                }
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
