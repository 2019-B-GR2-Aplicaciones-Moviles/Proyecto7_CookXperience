package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ConsultarRecetas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_recetas)
    }
    fun onClickverReceta(view: View){
        val intentPrincipal= Intent(this, VerReceta::class.java)
        startActivity(intentPrincipal)
    }
}
