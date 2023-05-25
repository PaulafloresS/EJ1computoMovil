package com.example.listview
import android.app.Activity
import android.widget.Toast

fun Activity.mensaje(text: String){
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}