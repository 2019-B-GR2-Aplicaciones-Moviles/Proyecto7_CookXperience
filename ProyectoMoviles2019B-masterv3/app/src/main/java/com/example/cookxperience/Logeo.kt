package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.examenapplication.Usuario
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_logeo.*


class Logeo : AppCompatActivity() {
    private val usuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logeo)
        UsuarioHttp().obtenerUsuarios()
        btnIngresar.setOnClickListener {
            validar()
        }

    }

    fun ingresarPrincipal(){
        val intentPrincipal=Intent(this, Principal::class.java)
        startActivity(intentPrincipal)
    }


    fun validar(){
        val usuarioFil= BDD.usuario.filter {
            it.nombreUsuario==txtUser.text.toString()
        }

        if(usuarioFil.isEmpty()){
            Alerter.create(this@Logeo)
                .setTitle(getString(R.string.msjCredenciales)+" ${txtUser.text.toString()}")

                .show()
        }else if(!usuarioFil[0].clave.equals(txtPassword.text.toString())){
            Alerter.create(this@Logeo)
                .setTitle(getString(R.string.msjCredenciales)+" ${txtUser.text.toString()}")

                .show()
        }else{
            ingresarPrincipal()
        }

    }
}

