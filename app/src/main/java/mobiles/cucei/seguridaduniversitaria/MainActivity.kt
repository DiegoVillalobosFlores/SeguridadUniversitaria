package mobiles.cucei.seguridaduniversitaria

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.AssaultActivities.VictimDetails
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import org.json.JSONObject
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var reporte:JSONObject
    private lateinit var user:Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        section_header_text_header.text = "Mis Reportes"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_late_black_24dp))

        reporte = JSONObject(intent.getStringExtra("reporte"))
        user = intent.getSerializableExtra("user") as Usuario

        main_text_incident_type.text = reporte.get("type").toString()
        main_text_incident_date.text = reporte.get("Fecha").toString()
        main_text_incident_name.text = reporte.get("Nombre").toString()
    }

    fun onNewReportClick(view: View){

        val intent = Intent(this,VictimDetails::class.java)
        intent.putExtra("user",user as Serializable)
        startActivity(intent)
    }
}
