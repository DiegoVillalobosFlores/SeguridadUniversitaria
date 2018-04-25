package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_especificaciones.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Atracante
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R

class Especificaciones : AppCompatActivity() {

    private lateinit var user:Usuario
    private lateinit var incident:Incidente
    private lateinit var agresor:Atracante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificaciones)

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente
        agresor = intent.getSerializableExtra("agresor") as Atracante

        section_header_text_header.text = "Especificaciones"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))

    }

    fun onNext(view: View){
        agresor.ropa = especificaciones_text_ropa.text.toString()
        agresor.gorra = especificaciones_text_gorra.text.toString()
        agresor.cicatrices = especificaciones_text_cicatrices.text.toString()
        agresor.tatuajes = especificaciones_text_tatuajes.text.toString()
        agresor.piercing = especificaciones_text_piercing.text.toString()

        val intent = Intent(this,Escape::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        intent.putExtra("agresor",agresor)
        startActivity(intent)
    }
}
