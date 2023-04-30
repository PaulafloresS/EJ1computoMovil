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