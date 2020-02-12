package com.example.cookxperience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_consultar_recetas.*

class ConsultarRecetas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RecetaHTTP().obtenerTodos()
        setContentView(R.layout.activity_consultar_recetas)
        for (receta in BDD.receta) {
            Log.i("bdd-", receta.nombre)

        }
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
      //  val rv = rvRecetas
    }
    fun onClickverReceta(view: View){
        val intentPrincipal= Intent(this, VerReceta::class.java)
        startActivity(intentPrincipal)
    }}



/*
        setContentView(R.layout.activity_listar_equipo)

        EquipoHttp().obtenerTodos()
        UsuarioHttp().obtenerUsuarios()


        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        val rv = rview_equipo

        val adaptador = PersonasAdaptador(BDD.equipo, this)

        rview_equipo.layoutManager = layoutManager
        rview_equipo.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rview_equipo.adapter = adaptador

        adaptador.notifyDataSetChanged()

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("int", "$resultCode")


        when (resultCode) {
            AppCompatActivity.RESULT_OK -> {

                Log.i("int", "$requestCode")
                Log.i("int", "$resultCode")
                Log.i("int", "$data")


                Log.i("intent-nombreCompletoJugador-apellido", "LLEGOOOO ${data!!.getParcelableExtra<Equipo?>("equipo_pasar")}")

                val equipo = data!!.getParcelableExtra<Equipo?>("equipo_pasar")


                if (equipo != null) {

                    Log.i("as","asdfdsfasd")
                    actualizarEqu(equipo)
                    Alerter.create(this@ListarEquipoActivity)
                        .setTitle(getString(R.string.msgEliminar)+" ${equipo!!.nombre}")
                        .setText(getString(R.string.txtUsuario)+ " ${BDD.usuario[0].nombre}")
                        .show()
                }




            }

            RESULT_CANCELED -> {
                Log.i("error", "Error")
            }
        }


    }



    companion object {
        val requestCodeActualizar = 101
    }
    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

}


}
*/