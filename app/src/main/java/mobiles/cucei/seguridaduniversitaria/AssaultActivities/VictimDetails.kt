package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_victim_details.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R
import java.io.Serializable

class VictimDetails : AppCompatActivity() {

    var user:Usuario = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victim_details)

        section_header_text_header.text = "Datos del Afectado"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario

    }

    fun onVictimSelfClick(view: View){
        val switch: Switch = view as Switch
        if(switch.isChecked){
            victim_details_edit_text_name.setText(user.name)
            victim_details_edit_text_institution.setText("Universidad de Guadalajara")
            victim_details_edit_text_campus.setText(user.centro)
            victim_details_edit_text_career.setText(user.carrera)
        }else{
            victim_details_edit_text_name.setText("")
            victim_details_edit_text_institution.setText("")
            victim_details_edit_text_campus.setText("")
            victim_details_edit_text_career.setText("")
        }
    }

    fun validateFields(){
        victim_details_fab_next.visibility = View.GONE
        if (victim_details_edit_text_name.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_institution.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_campus.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_career.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_email.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_phone_home.text.isEmpty()){
            return
        }
        if (victim_details_edit_text_phone_cel.text.isEmpty()){
            return
        }
        if (user.gender.isEmpty()){
            return
        }
        victim_details_fab_next.visibility = View.VISIBLE
    }

    fun onNext(view: View){
        user.name = victim_details_edit_text_name.text.toString()
        user.institution = victim_details_edit_text_institution.text.toString()
        user.centro = victim_details_edit_text_campus.text.toString()
        user.carrera = victim_details_edit_text_career.text.toString()
        user.email = victim_details_edit_text_email.text.toString()
        user.telCasa = victim_details_edit_text_phone_home.text.toString()
        user.telCel = victim_details_edit_text_phone_cel.text.toString()

        val intent = Intent(this, IncidentDetails::class.java)
        intent.putExtra("user",user as Serializable)
        startActivity(intent)
    }

    fun onGenderRadioClick(view: View){
        val checked = (view as RadioButton).isChecked

        when(view){
            victim_details_radio_man -> if(checked) user.gender = "Hombre"
            victim_details_radio_woman -> if(checked) user.gender = "Mujer"
            victim_details_radio_other -> if(checked) user.gender = "Otro"
        }
    }
}
