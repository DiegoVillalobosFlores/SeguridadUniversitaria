package mobiles.cucei.seguridaduniversitaria

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_settings.*
import mobiles.cucei.seguridaduniversitaria.Data.Usuario

/**
 * Created by deimi on 2/15/2018.
 */
class SettingsActivity : AppCompatActivity() {

    private  var user:Usuario = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        user = intent.getSerializableExtra("user") as Usuario

        settings_text_name.text = user.Nombre
        settings_text_campus.text = user.Sede
        settings_text_career.text = user.carrera

    }

    fun onSettingEdit(view: View){
        when (view){
            settings_layout_name -> {
                settings_text_name.visibility = View.GONE
                settings_layout_edit_name.visibility = View.VISIBLE
                settings_edit_text_name.setOnEditorActionListener { v, actionId, event -> handleTextEditActions(settings_layout_edit_name,settings_text_name,actionId) }
            }
        }
    }

    fun handleTextEditActions(gone: View, visible: View, actionId: Int) : Boolean{
        when (actionId){
            EditorInfo.IME_ACTION_DONE -> return changeViewVisibility(gone,visible)
        }
        return false
    }

    fun changeViewVisibility(gone: View, visible: View) : Boolean{
        gone.visibility = View.GONE
        visible.visibility = View.VISIBLE

        return true
    }

    fun finishSettingsEdit(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}