package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Atracante
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.MainActivity
import mobiles.cucei.seguridaduniversitaria.R
import org.json.JSONObject

class Final : AppCompatActivity() {

    private lateinit var user:Usuario
    private lateinit var incident:Incidente
    private lateinit var agresor:Atracante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        section_header_text_header.text = "Detalles finales"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_assignment_turned_in_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario
        incident = intent.getSerializableExtra("incident") as Incidente
        agresor = intent.getSerializableExtra("agresor") as Atracante

        final_number_picker_detained_suspects.maxValue = 10
        final_number_picker_detained_suspects.wrapSelectorWheel = true
    }

    fun onFinish(view: View){
        incident.NumeroDetenidos = final_number_picker_detained_suspects.value.toString()
        incident.escapeDetails = final_text_details.text.toString()

        section_header_text_header.text = "Enviando reporte..."
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_backup_black_24dp))
        final_layout_main.visibility = View.GONE
        final_fab_finish.visibility = View.GONE
        final_progress_submit.visibility = View.VISIBLE
        final_text_error.visibility = View.GONE

        val url = getString(R.string.API) + getString(R.string.API_Insert)
        val gson = Gson()
        var json = mergeJSON(JSONObject(gson.toJson(user)),JSONObject(gson.toJson(incident)))
        json = mergeJSON(json, JSONObject(gson.toJson(agresor)))

        Log.d("ULT JSON",json.toString())

        Fuel.post(url).body(json.toString()).responseString{ request,response,result ->
            Log.d("RESULT",result.toString())
            val res: List<String> = result.toString().split(":").map { it.trim() }
            val succ = res[1].dropLast(1)
            Log.d("SUCC",succ)
            if(succ == "true" ){
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("reporte",json.toString())
                intent.putExtra("user",user)
                startActivity(intent)
            }else{
                final_layout_main.visibility = View.GONE
                final_fab_finish.visibility = View.GONE
                final_progress_submit.visibility = View.VISIBLE
                final_text_error.visibility = View.VISIBLE
            }
        }
    }

    fun mergeJSON(json1:JSONObject,json2:JSONObject) : JSONObject{
        val mergedJSON:JSONObject = json1
        try {
            for (key:String in json2.keys()){
                mergedJSON.put(key,json2.get(key))
            }
        }catch (ex:Exception){
            ex.printStackTrace()
        }
        return mergedJSON
    }
}
