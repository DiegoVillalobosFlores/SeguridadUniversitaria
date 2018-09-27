package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_media_filacion.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Atracante
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R
import org.jetbrains.anko.textColor

class MediaFilacion : AppCompatActivity() {

    private lateinit var user:Usuario
    private lateinit var incident:Incidente
    private lateinit var lastSelected:TextView
    private lateinit var agresor: Atracante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_filacion)

        section_header_text_header.text = "Media filación del agresor"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_ind_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente
        agresor = intent.getSerializableExtra("agresor") as Atracante

        lastSelected = media_filacion_text_alargada
    }

    fun onFaceClicked(view: View){
        when (view) {
            media_filacion_layout_alargada -> setFaceType("Alargada",media_filacion_text_alargada)
            media_filacion_layout_corazon -> setFaceType("Corazón",media_filacion_text_corazon)
            media_filacion_layout_cuadrada -> setFaceType("Cuadrada",media_filacion_text_cuadrada)
            media_filacion_layout_diamante -> setFaceType("Diamante",media_filacion_text_diamante)
            media_filacion_layout_ovalada -> setFaceType("Ovalada",media_filacion_text_ovalada)
            media_filacion_layout_rectangulo -> setFaceType("Rectangulo",media_filacion_text_rectangulo)
            media_filacion_layout_redonda -> setFaceType("Redonda",media_filacion_text_redonda)
            media_filacion_layout_triangulo -> setFaceType("Triangulo",media_filacion_text_triangulo)
            media_filacion_layout_triangulo_invertido -> setFaceType("Triangulo Invertido",media_filacion_text_triangulo_invertido)
        }
    }

    fun setFaceType(type:String,textView: TextView){
        agresor.cara = type
        lastSelected.textColor = ContextCompat.getColor(this,android.R.color.tab_indicator_text)
        textView.textColor = ContextCompat.getColor(this,R.color.colorAccent)
        lastSelected = textView
    }

    fun onNext(view: View){
        val intent = Intent(this,Especificaciones::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        intent.putExtra("agresor",agresor)

        startActivity(intent)
    }
}
