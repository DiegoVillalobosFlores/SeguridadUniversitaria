package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_escape.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Atracante
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R
import org.jetbrains.anko.textColor

class Escape : AppCompatActivity() {

    private lateinit var user:Usuario
    private lateinit var incident:Incidente
    private lateinit var agresor:Atracante
    private lateinit var lastSelected: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escape)

        section_header_text_header.text = "Método de escape"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_directions_run_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente
        agresor = intent.getSerializableExtra("agresor") as Atracante

        lastSelected = escape_text_auto
    }

    fun onTransportClicked(view: View){
        when (view){
            escape_layout_auto -> setTransportType("Auto",escape_text_auto)
            escape_layout_bici -> setTransportType("Bicicleta",escape_text_bicicleta)
            escape_layout_moto -> setTransportType("Motocicleta",escape_text_moto)
            escape_layout_pie -> setTransportType("A Pie",escape_text_pie)
        }
    }

    fun setTransportType(type:String,textView: TextView){
        incident.MedioHuida = type
        lastSelected.textColor = ContextCompat.getColor(this,android.R.color.tab_indicator_text)
        textView.textColor = ContextCompat.getColor(this,R.color.colorAccent)
        lastSelected = textView
    }

    fun onNext(view: View){
        incident.escapeDetails = escape_text_edit_details.text.toString()

        val intent = Intent(this,Final::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        intent.putExtra("agresor",agresor)

        startActivity(intent)
    }
}
