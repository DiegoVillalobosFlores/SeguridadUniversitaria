package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_incident_details_type.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R
import org.jetbrains.anko.textColor

class IncidentDetailsType : AppCompatActivity() {

    private lateinit var incident:Incidente
    private lateinit var user:Usuario
    private lateinit var lastSelected:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incident_details_type)

        section_header_text_header.text = "Descripción del incidente"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_assignment_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente

        lastSelected = incident_details_text_other
    }

    fun onTypeClicked(view: View){
        when (view){
            incident_type_layout_agression -> selectType("Agresión",incident_details_text_agression)
            incident_type_layout_kidnapping -> selectType("Intento de secuestro",incident_details_text_kidnapping)
            incident_type_layout_rob_gun -> selectType("Robo con arma de fuego",incident_details_text_rob_gun)
            incident_type_layout_rob_knife -> selectType("Robo con arma blanca",incident_details_text_rob_knife)
            incident_type_layout_extortion -> selectType("Extorsión",incident_details_text_extortion)
            incident_type_layout_rape -> selectType("Atento de violación",incident_details_text_rape)
            incident_type_layout_creep -> selectType("Acoso",incident_details_text_creep)
            incident_type_layout_kush -> selectType("Drogadicción",incident_details_text_kush)
            incident_type_layout_other -> {
                if(incident_type_layout_text_other.visibility == View.VISIBLE){
                    incident_type_layout_text_other.visibility = View.GONE
                }else{
                    incident_type_layout_text_other.visibility = View.VISIBLE
                }
            }
        }
    }

    fun selectType(type:String,textView: TextView){
        incident.type = type
        lastSelected.textColor = ContextCompat.getColor(this,android.R.color.tab_indicator_text)
        textView.textColor = ContextCompat.getColor(this,R.color.colorAccent)
        lastSelected = textView
    }

    fun onNext(view: View){
        incident.description = incident_details_edit_text_description.text.toString()
        val intent = Intent(this,Agresor::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        startActivity(intent)
    }
}
