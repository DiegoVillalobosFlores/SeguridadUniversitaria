package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.R

class IncidentDetailsType : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incident_details_type)

        section_header_text_header.text = "Descripción del incidente"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_assignment_black_24dp))
    }
}
