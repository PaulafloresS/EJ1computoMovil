package com.example.ejercicio2.view.adapters
import com.example.ejercicio2.databinding.HarryBinding
import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R
import com.example.ejercicio2.model.Estudiantes

class EstudianteAdapter(private var context: Context, private var estudiantes: ArrayList<Estudiantes>, private val clickListener: (Estudiantes) -> Unit): RecyclerView.Adapter<EstudianteAdapter.ViewHolder>() {
    class ViewHolder(view: HarryBinding): RecyclerView.ViewHolder(view.root){
        var ivestudiante = view.ivestudiantes
        var tvNombre = view.tvNombre
        var tvActor = view.tvActor
        var tvid = view.tvid
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HarryBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int = estudiantes.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actor = estudiantes[position].actor
        val nombre = estudiantes[position].name
        val id = estudiantes[position].house
        val hair = estudiantes[position].hairColour
        if(actor.isNullOrEmpty()){
            holder.tvActor.text = context.getString(R.string.sindato)
        }else{
            holder.tvActor.text = actor
        }
        if(nombre.isNullOrEmpty()){
            holder.tvNombre.text = context.getString(R.string.sindato)
        }else{
            holder.tvNombre.text = nombre
        }
        if(id.isNullOrEmpty()){
            holder.tvid.text = context.getString(R.string.sindato)
        }else{
            holder.tvid.text = id
        }
        Glide.with(context)
            .load(estudiantes[position].image)
            .placeholder(R.drawable.sombrero)
            .into(holder.ivestudiante)
        holder.itemView.setOnClickListener {
            // programar los eventos click a todo el elemento del ViewHolder
            clickListener(estudiantes[position])
        }
        if(estudiantes[position].image == null){
            holder.ivestudiante.setImageResource(R.drawable.sombrero)
        }
    }
}