package com.example.ej1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.*
import com.example.ej1.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //var patron:Pattern=Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}\$")
    //var comparador:Matcher = patron.matcher(binding.etEmail.text)

    var diaa =0
    var mess = 0
    var anioo =0
    var bandera = true
    var age =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  binding.tvFechaNac.text = calculateAge(binding.).toString()
        //spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val lista = resources.getStringArray(R.array.carreras)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador
        val btn: Button = findViewById(R.id.boton)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        //date picker
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

                    age = calculateAge(selectedDate.timeInMillis)
                    diaa = selectedDayOfMonth
                    mess= selectedMonth
                    anioo = selectedYear
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


        //datos


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

private fun isValidEmail(email: EditText)=
    (!TextUtils.isEmpty(email.toString()) && Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches())
    fun click(view: View) {
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
            }else{
                bandera=true
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
            if(isValidEmail(binding.etEmail)){
                bandera=true
            }else{
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.correo_invalido),
                    Toast.LENGTH_LONG
                ).show()

            }
        }

        if (bandera == true) {
            val intent = Intent(this, Datos::class.java)
            intent.putExtra("nombre", binding.etNombre.text.toString())
            intent.putExtra("apellido", binding.etApellido.text.toString())
            intent.putExtra("email", binding.etEmail.text.toString())
            intent.putExtra("num_cuenta", binding.etNumCuenta.text.toString())
            intent.putExtra("fecha_nac", age.toString())
            intent.putExtra("dia",diaa)
            intent.putExtra("mes",mess)
            intent.putExtra("anio",anioo)

            startActivity(intent)

        }


    }
}