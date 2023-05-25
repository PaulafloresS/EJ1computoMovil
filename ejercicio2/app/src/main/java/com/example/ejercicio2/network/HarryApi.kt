package com.example.ejercicio2.network


import com.example.ejercicio2.model.Estudiantes
import com.example.ejercicio2.model.EstudianteDetail
import android.telecom.Call
import  retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface HarryApi {
    @GET
    fun getEstudiantes(
        @Url url: String?
    ): retrofit2.Call<ArrayList<Estudiantes>>

    @GET("Estudiantes/EstudianteDetail/{id}")
    fun getEstudianteDetailApiary(
        @Path("id") id: String? = null
    ): retrofit2.Call<EstudianteDetail>
   // https://private-b725c-harrypotter1.apiary-mock.com/harryPotter/Estudiantes/EstudianteDetail/1
}