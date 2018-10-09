package mobiles.cucei.seguridaduniversitaria

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_login.*
import mobiles.cucei.seguridaduniversitaria.AssaultActivities.VictimDetails
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R.id.login_button_login
import org.jetbrains.anko.share
import java.io.Serializable



class LoginActivity : AppCompatActivity() {


    private lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPref = getPreferences(Context.MODE_PRIVATE)
        val code = sharedPref.getString(getString(R.string.code),"")
        val nip = sharedPref.getString(getString(R.string.nip),"")
        login_textinput_codigo.setText(code)
        login_textinput_nip.setText(nip)
        handleNoInternet()

        login_button_login.setOnClickListener {
            handleNoInternet()
        }

    }

    private fun handleNoInternet(){
        if(!isNetworkAvailable(this)){
            login_button_login.text = "Reintentar"
            login_text_error_no_network.visibility = View.VISIBLE
        }else{
            login_button_login.text = "Siguiente"
            login_text_error_no_network.visibility = View.GONE
            login_button_login.setOnClickListener {
                loginUser()
            }
        }
    }

    private fun loginUser(){
        if(!isNetworkAvailable(this)){
            handleNoInternet()
            return
        }

        login_layout_linear_loginform.visibility = View.GONE
        login_progress_loadinglogin.visibility = View.VISIBLE
        val url = getString(R.string.API) + getString(R.string.API_Login)
        val codigo = login_textinput_codigo.text.toString()
        val nip = login_textinput_nip.text.toString()

        Fuel.post(url).body("codigo=$codigo&nip=$nip").responseString { _, _, result ->

            Log.d("RESULT",result.toString())
            var res: List<String> = result.toString().split(":").map { it.trim() }
            Log.d("SUCC",res[1])
            if(res[1] != "0]"){
                res = res[1].split(",").map { it.trim() }
                val user = Usuario(res[0],res[1],res[2].toLowerCase().capitalize(),res[3],deleteUnwantedChars(res[4]))

                Log.d("USER",user.toString())
                with (sharedPref.edit()) {
                    putString(getString(R.string.code), codigo)
                    putString(getString(R.string.nip), nip)
                    commit()
                }

                val intent = Intent(this,VictimDetails::class.java)
                intent.putExtra("user",user as Serializable)
                startActivity(intent)

                login_progress_loadinglogin.visibility = View.GONE
                login_layout_linear_loginform.visibility = View.VISIBLE
            }else{
                login_text_error.visibility = View.VISIBLE
                login_progress_loadinglogin.visibility = View.GONE
                login_layout_linear_loginform.visibility = View.VISIBLE
            }
        }
    }

    private fun deleteUnwantedChars(text:String) : String{
        return text.dropLast(1)
    }

    fun onHelpClick(v: View){
        val intent = Intent(this,HelpActivity::class.java)
        startActivity(intent)
    }

    fun onAboutClick(v: View){
        val intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

}
