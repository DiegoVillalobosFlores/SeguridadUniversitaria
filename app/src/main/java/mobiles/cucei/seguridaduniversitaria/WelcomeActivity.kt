package mobiles.cucei.seguridaduniversitaria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*
import mobiles.cucei.seguridaduniversitaria.Data.Usuario

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val user = intent.getSerializableExtra("user") as Usuario
        welcome_text_name.text = user.name
    }
}
