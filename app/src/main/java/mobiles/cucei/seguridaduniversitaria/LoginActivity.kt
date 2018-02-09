package mobiles.cucei.seguridaduniversitaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.experimental.async
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.io.Serializable
import java.net.URL



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener({
            login_layout_linear_loginform.visibility = View.GONE
            login_progress_loadinglogin.visibility = View.VISIBLE
            val url = getString(R.string.API) + getString(R.string.API_Login)
            val codigo = login_textinput_codigo.text.toString()
            val nip = login_textinput_nip.text.toString()

            Fuel.post(url).body("codigo=$codigo&nip=$nip").responseString { request, response, result ->

                var res: List<String> = result.toString().split(":").map { it.trim() }
                if(res[1] != "0"){
                    res = res[1].split(",").map { it.trim() }
                    val user = Usuario(res[0],res[1],res[2],res[3],res[4])

                    val intent = Intent(this,WelcomeActivity::class.java)
                    intent.putExtra("user",user as Serializable)
                    startActivity(intent)
                }

                login_progress_loadinglogin.visibility = View.GONE
                login_layout_linear_loginform.visibility = View.VISIBLE
            }
        })
    }
}
