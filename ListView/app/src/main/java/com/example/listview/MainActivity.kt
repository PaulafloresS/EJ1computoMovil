package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.model.Homero
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datos = ArrayList<Homero>()
        for(i in 1..10) {
            val homeroTemp = Homero(
                i +Random.nextLong(1000),
                "Titulo $i",
                "Tipo $i",
                 "Fecha $i")
            datos.add(homeroTemp)
        }
        val miAdapter = Adapter(this,datos)
        binding.lv.adapter = miAdapter
        binding.lv.setOnItemClickListener { parent, view, position, id ->
          mensaje("Clic en el elemento con posiscion $position y id $id")
            val homero = parent.adapter.getItem(position) as Homero
            mensaje("Click en el elemento con titulo: ${homero.titulo}")

        }

    }
}


