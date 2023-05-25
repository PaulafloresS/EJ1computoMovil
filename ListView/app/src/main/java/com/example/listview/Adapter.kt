package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.listview.databinding.ElementoListaBinding
import com.example.listview.model.Homero
import java.text.FieldPosition

class Adapter(val context: Context, val datos: ArrayList<Homero>): BaseAdapter() {
    val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int = datos.size //tamaño del arreglo de la variable datos
    override fun getItem(position: Int): Any=datos[position]//el adapter viene en una posicion y regresa el item en esa posicion
    override fun getItemId(position: Int): Long = datos[position].id
    override fun getView(position:Int, convertView: View?, parent:ViewGroup?): View{
        val binding = ElementoListaBinding.inflate(inflater)
       with(binding){
           tvTitle.text = datos[position].titulo
           tvTipo.text = datos[position].tipo
           tvFecha.text = datos[position].fecha
       }

        //para hacer dinamicas las imagenes podemos utilizar los image View
        return binding.root


    }


}