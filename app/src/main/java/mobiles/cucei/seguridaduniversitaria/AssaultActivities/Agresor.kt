package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_agresor2.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Atracante
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R

class Agresor : AdapterView.OnItemSelectedListener, AppCompatActivity() {

    private lateinit var user:Usuario
    private lateinit var incident:Incidente
    private val agresor: Atracante = Atracante()
    private lateinit var cabelloColor:Array<String>
    private lateinit var cabelloTipo:Array<String>
    private lateinit var ojosColor:Array<String>

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent){
            agresor_spinner_cabello_color -> agresor.cabelloColor = cabelloColor[position]
            agresor_spinner_cabello_tipo -> agresor.cabelloTipo = cabelloTipo[position]
            agresor_spinner_ojos_color -> agresor.ojosColor = ojosColor[position]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agresor2)

        section_header_text_header.text = "Detalles del Agresor"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))

        cabelloColor = resources.getStringArray(R.array.hair_color)
        agresor_spinner_cabello_color.onItemSelectedListener = this
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,cabelloColor)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_cabello_color.adapter = arrayAdapter

        cabelloTipo = resources.getStringArray(R.array.hair_type)
        agresor_spinner_cabello_tipo.onItemSelectedListener = this
        val arrayAdapterType = ArrayAdapter(this,android.R.layout.simple_spinner_item,cabelloTipo)
        arrayAdapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_cabello_tipo.adapter = arrayAdapterType

        ojosColor = resources.getStringArray(R.array.ojos_color)
        agresor_spinner_ojos_color.onItemSelectedListener = this
        val arrayAdapterEyesColor = ArrayAdapter(this,android.R.layout.simple_spinner_item,ojosColor)
        arrayAdapterEyesColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        agresor_spinner_ojos_color.adapter = arrayAdapterEyesColor

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente

    }

    fun onNext(view: View){

        agresor.EstaturaAgresor = agresor_edit_text_estatura.text.toString()
        agresor.EdadAproxAgresor = agresor_edit_text_edad.text.toString()
        agresor.OtraSenaAgresor = agresor_edit_text_senas_particulares.text.toString()
        agresor.BocaAgresor = agresor_text_edit_boca.text.toString()
        agresor.TezAgresor = agresor_edit_text_tez.text.toString()
        agresor.OjosAgresor = agresor.ojosColor
        agresor.CabelloAgresor = agresor.cabelloTipo + " " + agresor.cabelloColor

        val intent = Intent(this,MediaFilacion::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        intent.putExtra("agresor",agresor)
        startActivity(intent)
    }

}
