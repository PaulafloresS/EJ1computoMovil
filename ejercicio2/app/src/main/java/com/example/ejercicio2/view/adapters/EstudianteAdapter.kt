package com.example.ejercicio2.view.adapters
import com.example.ejercicio2.databinding.HarryBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.model.Estudiantes

class EstudianteAdapter(private var context: Context, private var estudiantes: ArrayList<Estudiantes>, private val clickListener: (Estudiantes) -> Unit): RecyclerView.Adapter<EstudianteAdapter.ViewHolder>() {
    class ViewHolder(view: HarryBinding): RecyclerView.ViewHolder(view.root){
        val ivestudiante = view.ivestudiantes
        val tvNombre = view.tvNombre
        val tvActor = view.tvActor
        val tvid = view.tvid
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HarryBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)

    }
    override fun getItemCount(): Int = estudiantes.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = estudiantes[position].name
        holder.tvActor.text = estudiantes[position].actor
        holder.tvid.text = estudiantes[position].id
        Glide.with(context)
            .load(estudiantes[position].image)
            .into(holder.ivestudiante)
            holder.itemView.setOnClickListener {
                // programar los eventos click a todo el elemento del ViewHolder
                clickListener(estudiantes[position])
            }

    }



}