package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun onClickIngresarPricipal(view: View){
        val intentPrincipal= Intent(this, Principal::class.java)
        startActivity(intentPrincipal)
    }
}
