package com.example.ej1

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.ej1.databinding.ActivityMainBinding
import java.text.FieldPosition
import java.util.Calendar
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    var bandera = true
    var age =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv_fechaNac)
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  binding.tvFechaNac.text = calculateAge(binding.).toString()
        //spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val lista = resources.getStringArray(R.array.carreras)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador
        val btn: Button = findViewById(R.id.boton)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        //date picker


        tv.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDayOfMonth)

                    tv.text = "Date: $selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                     age = calculateAge(selectedDate.timeInMillis)
                    // Aquí puedes usar la variable age para hacer lo que necesites con la edad calculada
                },
                year,
                month,
                day
            )

            datePickerDialog.datePicker.maxDate =
                System.currentTimeMillis() // Aquí se establece la fecha máxima permitida

            datePickerDialog.show()
        }

        //calculando horoscopos



    }

    //calculando la edad
    private fun calculateAge(birthdate: Long): Int {
        val dob = Calendar.getInstance()
        dob.timeInMillis = birthdate

        val today = Calendar.getInstance()
        var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--
        }

        return age

    }


    fun click(view: View) {


        when (view.id) {
        }

        with(binding) {
            if (etNombre.text.isEmpty()) {
                etNombre.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }else{
                bandera =true
            }
            if (etApellido.text.isEmpty()) {
                etApellido.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }else{
                bandera = true
            }

            if (etEmail.text.isEmpty()) {
                etEmail.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }else{
                bandera=true
            }
            if (etNumCuenta.text.isEmpty()) {
                etNumCuenta.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }else{
                bandera= true
            }
            if (tvFechaNac.text.isEmpty()) {
                tvFechaNac.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }
            if(binding.spinner.selectedItemPosition ==0){
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
                bandera = false
            }else{
                bandera = true
            }
        }
        if (bandera == true) {
            val intent = Intent(this, Datos::class.java)
            intent.putExtra("nombre", binding.etNombre.text.toString())
            intent.putExtra("apellido", binding.etApellido.text.toString())
            intent.putExtra("email", binding.etEmail.text.toString())
            intent.putExtra("num_cuenta", binding.etNumCuenta.text.toString())
            intent.putExtra("fecha_nac", age.toString())

            startActivity(intent)

        }


    }
}