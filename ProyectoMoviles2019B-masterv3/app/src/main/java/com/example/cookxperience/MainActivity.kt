package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onclickRegistrar(view: View){
        val intentRegister= Intent(this,Register::class.java)
        startActivity(intentRegister)
    }
    fun onclickLogeo(view: View){
        val intentLogeo= Intent(this,Logeo::class.java)
        startActivity(intentLogeo)
    }
}
