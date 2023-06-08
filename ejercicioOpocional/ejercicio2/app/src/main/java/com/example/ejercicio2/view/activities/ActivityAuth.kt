package com.example.ejercicio2.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2.R
import com.example.ejercicio2.databinding.ActivityAuthBinding
import com.example.ejercicio2.databinding.ActivityMainBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class ActivityAuth : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var email=""
    private var contrasenia =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonlogin.setOnClickListener{
            if(!validaCamos()) return@setOnClickListener
         //   binding.progressBar.visibility = View.VISIBLE
            //autenticando al usuario
            autenticaUsuario(email,contrasenia)
        }

        binding.buttonregister.setOnClickListener{
            if(!validaCamos()) return@setOnClickListener
        //    binding.progressBar.visibility = View.VISIBLE
            //autenticando al usuario
            registraUsuario(email,contrasenia)
        }

    }
    private fun validaCamos(): Boolean{
        email = binding.etnamelogin.text.toString().trim()
        contrasenia = binding.etPasswordlogin.text.toString().trim()
        if(email.isEmpty()){
            binding.etnamelogin.error = getString(R.string.correo)
            binding.etnamelogin.requestFocus()
            return false
        }
        if(contrasenia.isEmpty()||contrasenia.length<6){
            binding.etPasswordlogin.error = getString(R.string.contrasenia)
            binding.etPasswordlogin.requestFocus()
            return false
        }
        return true
    }
    private fun autenticaUsuario(usr: String, psw: String){
        firebaseAuth.signInWithEmailAndPassword(usr,psw).addOnCompleteListener {authResult->
            if(authResult.isSuccessful){
                startActivity(Intent(this,MainActivity2::class.java))
                finish()
            }else{
              //  binding.progressBar.visibility = View.GONE
                manejaErrores(authResult)
            }

        }
    }
    private fun registraUsuario(usr: String, psw: String){
        firebaseAuth.createUserWithEmailAndPassword(usr,psw).addOnCompleteListener {authResult->
            if(authResult.isSuccessful){
                startActivity(Intent(this,MainActivity2::class.java))
                finish()
            }else{
         //       binding.progressBar.visibility = View.GONE
                manejaErrores(authResult)
            }

        }
    }
    private fun manejaErrores(task: Task<AuthResult>){
        var errorCode=""
        try{
            errorCode = (task.exception as FirebaseAuthException).errorCode
        }catch (e: java.lang.Exception){
            errorCode =getString(R.string.nonetwork)
        }
        when(errorCode){
            getString(R.string.wrongcorreo)->{
                Toast.makeText(this, getString(R.string.erroremail), Toast.LENGTH_LONG).show()
                binding.etnamelogin.error = getString(R.string.erroremailet)
                binding.etnamelogin.requestFocus()
                binding.etPasswordlogin.setText("")
            }
            getString(R.string.wrongpassword)->{
                Toast.makeText(this, getString(R.string.errorpassword), Toast.LENGTH_LONG).show()
                binding.etPasswordlogin.error = getString(R.string.errorpasswordos)
                binding.etPasswordlogin.requestFocus()
                binding.etPasswordlogin.setText("")
            }
            else->{
                Toast.makeText(this, getString(R.string.errorautenticacion), Toast.LENGTH_LONG).show()
            }

        }
    }

}