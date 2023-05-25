package com.example.ejercicio2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        setContentView(binding.root)
        val bundle = intent.extras
        val id = bundle?.getString("id","")

        val call = RetrofitService.getRetrofit().create(HarryApi::class.java)
            .getEstudianteDetailApiary(id)
        call.enqueue(object : Callback<EstudianteDetail> {
            override fun onResponse(
                call: Call<EstudianteDetail>,
                response: Response<EstudianteDetail>
            ) {
                binding.pbconectar.visibility = View.GONE

              //  binding.tvTitle.text = response.body()!!.title
                //cambiar el birth por lo que se ocupa
            //    binding.tvLongDesc.text = response.body()!!.birth

                Glide.with(this@Details)
                    .load(response.body()!!.image)
                    .into(binding.ivImage)
            }

            override fun onFailure(call: Call<EstudianteDetail>, t: Throwable) {
                binding.pbconectar.visibility = View.GONE
                Toast.makeText(this@Details, "No hay conexión", Toast.LENGTH_SHORT).show()
            }


        })

    }
}