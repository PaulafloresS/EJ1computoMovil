package com.example.ej1

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.ej1.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //var patron:Pattern=Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}\$")
    //var comparador:Matcher = patron.matcher(binding.etEmail.text)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val lista = resources.getStringArray(R.array.carreras)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,lista)
        spinner.adapter = adaptador
        val btn: Button = findViewById(R.id.boton)
        // datePicker
/*
        val tv = findViewById<TextView>(R.id.tv_fechaNac)
        val cal = Calendar.getInstance()
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        tv.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            tv.text = "Date :" +dayOfMonth+"/ "+(month+1) + "/ "+year
        },year,month,day)
        datePickerDialog.show()
        }
*/
        val tv = findViewById<TextView>(R.id.tv_fechaNac)
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        tv.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDayOfMonth)

                    tv.text = "Date: $selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                    val age = calculateAge(selectedDate.timeInMillis)
                    // Aquí puedes usar la variable age para hacer lo que necesites con la edad calculada
                },
                year,
                month,
                day
            )

            datePickerDialog.datePicker.maxDate = System.currentTimeMillis() // Aquí se establece la fecha máxima permitida

            datePickerDialog.show()
        }

    }

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


    fun click(view: View):Boolean {
        var isValid = true

        when(view.id) {
            R.id.boton -> {
                //pasar a otra activity
                val intent = Intent(this, Datos::class.java)
                val parameters = Bundle()
                parameters.putString("Nombre", binding.etNombre.text.toString())
                parameters.putString("Correo", binding.etEmail.text.toString())
                parameters.putString("Apellido", binding.etApellido.text.toString())
                parameters.putString("Fecha de nacimiento", binding.tvFechaNac.text.toString())
                //    parameters.putString("Carrera",binding.spinner.text.toString())

                intent.putExtras(parameters)
                startActivity(intent)


            }
        }

        with(binding) {
            if (etNombre.text.isEmpty()) {
                etNombre.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
            }
            if (etApellido.text.isEmpty()) {
                etApellido.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
            }

            if (etEmail.text.isEmpty()) {
                etEmail.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
            }
            if (etNumCuenta.text.isEmpty()) {
                etNumCuenta.error = getString(R.string.ingresa_valor)
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.ingresa_valor),
                    Toast.LENGTH_LONG
                ).show()
            }
           if(tvFechaNac.text.isEmpty()){
               tvFechaNac.error = getString(R.string.ingresa_valor)
               Toast.makeText(
                   this@MainActivity,
                   getString(R.string.ingresa_valor),
                   Toast.LENGTH_LONG
               ).show()
           }
        }
        return isValid


    }
}