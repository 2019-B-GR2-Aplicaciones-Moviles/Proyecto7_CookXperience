package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }
    fun onclickCrearReceta(view: View){
        val intentCrearRecta= Intent(this, Receta::class.java)
        startActivity(intentCrearRecta)
    }
    fun onclickConsultarReceta(view: View){
        val intentConsultarReceta= Intent(this, ConsultarRecetas::class.java)
        startActivity(intentConsultarReceta)
    }
    fun onclickVerPerfil(view: View){
        val intentVerPerfil= Intent(this, Perfil::class.java)
        startActivity(intentVerPerfil)
    }

}
