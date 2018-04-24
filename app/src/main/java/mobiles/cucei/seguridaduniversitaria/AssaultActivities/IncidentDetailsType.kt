package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_incident_details_type.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R

class IncidentDetailsType : AppCompatActivity() {

    private lateinit var incident:Incidente
    private lateinit var user:Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incident_details_type)

        section_header_text_header.text = "Descripción del incidente"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_assignment_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente

    }

    fun onTypeClicked(view: View){
        when (view){
            incident_type_layout_agression -> incident.type = "Agresión"
            incident_type_layout_kidnapping -> incident.type = "Intento de secuestro"
            incident_type_layout_rob_gun -> incident.type = "Robo con arma de fuego"
            incident_type_layout_rob_knife -> incident.type = "Robo con arma blanca"
            incident_type_layout_extortion -> incident.type = "Extorsión"
            incident_type_layout_rape -> incident.type = "Tentativa de violación"
        }
    }
}
