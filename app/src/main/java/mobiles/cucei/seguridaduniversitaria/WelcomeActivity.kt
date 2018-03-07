package mobiles.cucei.seguridaduniversitaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome.*
import mobiles.cucei.seguridaduniversitaria.Data.Usuario

class WelcomeActivity : AppCompatActivity() {

    private var user:Usuario = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        user = intent.getSerializableExtra("user") as Usuario
        welcome_text_name.text = user.name
    }

    fun newReport(view:View){
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    fun newOtherReport(view:View){

    }

    fun extraData(view: View){
        val intent = Intent(this,SettingsActivity::class.java)
        intent.putExtra("user",user)
        startActivity(intent)
    }
}
