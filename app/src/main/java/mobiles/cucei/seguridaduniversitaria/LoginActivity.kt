package mobiles.cucei.seguridaduniversitaria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URL

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener({
            login_layout_linear_loginform.visibility = View.GONE
            login_progress_loadinglogin.visibility = View.VISIBLE
            doAsync {
                val result = URL("148.202.152.33").readText()
                uiThread {
                    login_progress_loadinglogin.visibility = View.GONE
                    login_layout_linear_loginform.visibility = View.VISIBLE
                    Log.d("LOGIN",result)
                }

            }
        })
    }
}
