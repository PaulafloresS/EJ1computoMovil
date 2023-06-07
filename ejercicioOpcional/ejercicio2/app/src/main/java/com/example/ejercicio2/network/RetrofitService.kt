package com.example.ejercicio2.network

import android.provider.SyncStateContract.Constants
import com.example.ejercicio2.utils.Constans
import retrofit2.Retrofit
import  retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var INSTANCE: Retrofit? = null
    fun getRetrofit(): Retrofit = INSTANCE ?: synchronized(this){
        val instance = Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        INSTANCE = instance
        instance
    }
}
