package com.amaurypm.esprimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.amaurypm.esprimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var numero = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun click(view: View) {

        if(binding.etNumero.text.isNotEmpty()){
            numero = binding.etNumero.text.toString().toInt()

            if(esPrimo(numero)){
                binding.tvResultado.text = getString(R.string.si_primo, numero, "!")
            }else{
                binding.tvResultado.text = getString(R.string.no_primo, numero)
            }

            //Toast.makeText(this, "El número ingresado es: $numero", Toast.LENGTH_LONG).show()
        }else{
            binding.etNumero.error = resources.getString(R.string.valor_requerido)

            Toast.makeText(this, getString(R.string.ingresa_valor), Toast.LENGTH_LONG).show()
        }


    }

    fun esPrimo(numero: Int): Boolean{

        if(numero<=1) return false

        for(i in 2 until numero){
            if(numero%i == 0) return false
        }

        return true
    }
}