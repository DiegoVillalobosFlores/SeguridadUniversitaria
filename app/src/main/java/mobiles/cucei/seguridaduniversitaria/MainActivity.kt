package mobiles.cucei.seguridaduniversitaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.AssaultActivities.VictimDetails

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        section_header_text_header.text = "Mis Reportes"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_late_black_24dp))
    }

    fun onNewReportClick(view: View){
        val intent = Intent(this,VictimDetails::class.java)
        startActivity(intent)
    }
}
