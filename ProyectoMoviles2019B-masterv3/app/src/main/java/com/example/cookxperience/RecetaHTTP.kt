package com.example.cookxperience

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

class RecetaHTTP(
    var nombre:String,
    var tradicional: Boolean,
    var id: Int? = null

) {
    constructor(): this ("", false,0)


    val url = "http://192.168.56.1:1337/receta"

    fun crearReceta(usuarioId: Int?) {


        val parametros = listOf(
            "nombre" to nombre,
            "tradicional" to tradicional,
            "usuarioId" to usuarioId

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
/*
                        val usuarioString = result.get().parse<RecetaHTTP>(usuarioString)
*//*
                        Log.i("httpres", "Datos: ${recetaClase?.nombre}")
*/
                    }
                }
            }
    }



    fun eliminar(id:Int?){
        val urlParam = url+'/'+id
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

                        val recetaClase: RecetaHTTP? = Klaxon()
                            .parse<RecetaHTTP>(usuarioString)

                        Log.i("httpres", "Datos: ${recetaClase?.nombre}")

                    }
                }
            }
    }


    fun obtenerTodos() {
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpres", "Error: ${ex}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("data", "Data: ${data}")

                        val recetaArray = Klaxon().parseArray<RecetaHTTP>(data)
                        Log.i("httpres111", "Datos: ${recetaArray?.toString()}")
                        if (recetaArray != null) {
                            BDD.receta1.clear()
                            for ( receta in recetaArray.iterator()){
                                Log.i("httpres", "Receta: ${receta.nombre}")
                                Log.i("httpres", "Receta: ${receta.id}")

                                val recetaInsert = RecetaHTTP(receta.nombre, receta.tradicional, receta.id)
                                BDD.receta1.add(recetaInsert)
                            }
                        }

                    }
                }
            }
    }

    fun obtenerPorId(usuarioId: Int?){
//        val urlParam = url+'/'+id
        Log.i("usuarioId", "${usuarioId}")
        val parametros = listOf(
            "usuarioId" to usuarioId

        )
        url.httpGet(parametros)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpres", "Error: ${ex}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("data", "Data: ${data}")

                        val recetaArray = Klaxon().parseArray<RecetaHTTP>(data)
                        Log.i("httpres111", "Datos: ${recetaArray?.toString()}")
                        if (recetaArray != null) {
                            BDD.receta.clear()
                            for ( receta in recetaArray.iterator()){
                                Log.i("httpres", "Receta: ${receta.nombre}")
                                Log.i("httpres", "Receta: ${receta.id}")

                                val materiaInsert = RecetaHTTP(receta.nombre, receta.tradicional,  receta.id)
                                BDD.receta.add(materiaInsert)
                            }
                        }

                    }
                }
            }
    }

    fun actualizar(id:Int?){
        val urlParam = url+'/'+id

        val parametros = listOf(
            "nombre" to nombre,
            "tradicional" to tradicional

//            "idEstudiante" to idEstudiante

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

                        val recetaClase: RecetaHTTP? = Klaxon()
                            .parse<RecetaHTTP>(usuarioString)

                        Log.i("httpres", "Datos: ${recetaClase?.nombre}")

                    }
                }
            }
    }


}