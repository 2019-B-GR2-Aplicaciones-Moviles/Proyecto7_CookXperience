package com.example.cookxperience

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

class UsuarioHttp (
    var nombreUsuario: String,
    var mail: String,
    var usernameUsuario: String,
    var clave: String,

    var id: Int? = null
) : AppCompatActivity(){

    constructor(): this ("", "", "", "", 0)



    val url = "http://192.168.56.1:1337/usuario"

    fun crearUsuario() {

        val parametros = listOf(
            "nombreUsuario" to nombreUsuario,
            "mail" to mail,
            "usernameUsuario" to usernameUsuario,
            "clave" to clave


        )

        Log.i("httpres", parametros.toString())

        url
            .httpPost(parametros)
            .responseString { request, response, result ->

                when (result) {
                    is Result.Failure -> {
                        val exepcion = result.getException()
                        Log.i("httpres", "Error: ${exepcion}")
                        Log.i("httpres", "Error: ${response}")

                    }
                    is Result.Success -> {

                        val usuarioString = result.get()

                        val usuarioClase: UsuarioHttp? = Klaxon()
                            .parse<UsuarioHttp>(usuarioString)



                    }
                }
            }
    }

    fun obtenerTodos(){
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpres", "Error: ${ex}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("httpres", "${data}")

                        val usuarioArray = Klaxon().parseArray<UsuarioHttp>(data)
                        Log.i("httpres", "Datos: ${usuarioArray?.toString()}")
                        if (usuarioArray != null) {
                            BDD.usuario.clear()
                            for ( usuario in usuarioArray.iterator()){


                                val equipoInsert = UsuarioHttp(usuario.nombreUsuario, usuario.mail,
                                    usuario.usernameUsuario, usuario.clave)
                                BDD.usuario.add(equipoInsert)
                            }
                        }

                    }
                }
            }
    }
    fun obtenerPorId(id: Int?){
        var urlParam = url+'/'+id
        urlParam.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpres", "Error: ${ex}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("httpres", "${data}")

                        val usuarioArray = Klaxon().parseArray<UsuarioHttp>(data)
                        Log.i("httpres", "Datos: ${usuarioArray?.toString()}")
                        if (usuarioArray != null) {
                            BDD.usuario.clear()
                            for ( usuario in usuarioArray.iterator()){
                                val equipoInsert = UsuarioHttp(usuario.nombreUsuario, usuario.mail,
                                    usuario.usernameUsuario, usuario.clave)
                                BDD.usuario.add(equipoInsert)
                            }
                        }

                    }
                }
            }
    }
    fun eliminar(id:Int?){
        var urlParam = url+'/'+id
        urlParam.httpDelete()
            .responseString { request, response, result ->

                when (result) {
                    is Result.Failure -> {
                        val exepcion = result.getException()
                        Log.i("httpres", "Error: ${exepcion}")
                        Log.i("httpres", "Error: ${response}")

                    }
                    is Result.Success -> {

                        val usuarioString = result.get()

                        val usuarioClase: UsuarioHttp? = Klaxon()
                            .parse<UsuarioHttp>(usuarioString)



                    }
                }
            }
    }

    fun actualizar(id:Int?){
        val urlParam = url+'/'+id

        val parametros = listOf(
            "nombreUsuario" to nombreUsuario,
            "mail" to mail,
            "usernameUsuario" to usernameUsuario,
            "clave" to clave



        )

        urlParam.httpPut(parametros)
            .responseString { request, response, result ->

                when (result) {
                    is Result.Failure -> {
                        val exepcion = result.getException()
                        Log.i("httpres", "Error: ${exepcion}")
                        Log.i("httpres", "Error: ${response}")

                    }
                    is Result.Success -> {


                        val usuarioString = result.get()

                        val usuarioClase: UsuarioHttp? = Klaxon()
                            .parse<UsuarioHttp>(usuarioString)
                        obtenerTodos()

                    }
                }
            }
    }
    fun obtenerUsuarios() {
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpres11111", "Error: ${ex}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("httpres", "${data}")

                    }
                }

            }
    }

}