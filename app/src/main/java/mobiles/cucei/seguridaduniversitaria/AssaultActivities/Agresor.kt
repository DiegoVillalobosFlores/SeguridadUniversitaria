package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_agresor2.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.R
import org.jetbrains.anko.image

class Agresor : AdapterView.OnItemSelectedListener, AppCompatActivity() {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent){
            agresor_spinner_cabello_color -> Log.d("LEL","CABELLO")
            agresor_spinner_cabello_tipo -> Log.d("LEL","CABELLOTIPO")
            agresor_spinner_ojos_color -> Log.d("LEL","OJOS")
            else -> Log.d("LEL",parent?.id.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agresor2)
        section_header_text_header.text = "Detalles del Agresor"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))
        val cabelloColor = resources.getStringArray(R.array.hair_color)
        agresor_spinner_cabello_color.onItemSelectedListener = this
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,cabelloColor)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_cabello_color.adapter = arrayAdapter

        val cabelloTipo = resources.getStringArray(R.array.hair_type)
        agresor_spinner_cabello_tipo.onItemSelectedListener = this
        val arrayAdapterType = ArrayAdapter(this,android.R.layout.simple_spinner_item,cabelloTipo)
        arrayAdapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_cabello_tipo.adapter = arrayAdapterType

        val ojosColor = resources.getStringArray(R.array.ojos_color)
        agresor_spinner_ojos_color.onItemSelectedListener = this
        val arrayAdapterEyesColor = ArrayAdapter(this,android.R.layout.simple_spinner_item,ojosColor)
        arrayAdapterEyesColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_ojos_color.adapter = arrayAdapterEyesColor

    }
}
