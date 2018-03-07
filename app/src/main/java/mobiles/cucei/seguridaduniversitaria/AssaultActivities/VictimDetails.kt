package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_victim_details.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.R

class VictimDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victim_details)

        section_header_text_header.text = "Datos del Afectado"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))
    }

    fun onVictimSelfClick(view: View){
        val switch: Switch = view as Switch
        if(switch.isChecked){
            victim_details_edit_text_name.setText("Diego Eugenio Villalobos Flores")
        }else{
            victim_details_edit_text_name.setText("")
        }
    }

    fun onGenderRadioClick(view: View){
        val checked = (view as RadioButton).isChecked

        when(view){
            victim_details_radio_man -> if(checked) Log.d("Radio","Man")
            victim_details_radio_woman -> if(checked) Log.d("Radio","Woman")
            victim_details_radio_other -> if(checked) Log.d("Radio","Other")
        }
    }
}
