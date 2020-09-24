package cl.freedom.wheatermvvm.splash

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import cl.freedom.wheatermvvm.R
import cl.freedom.wheatermvvm.dashboard.ui.CurrentCovidActivity
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import java.lang.Exception
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(){

    @Inject
    lateinit var logo : Drawable

    @Inject
    lateinit var requestManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setLogo()

        val background = object : Thread()
        {
            override fun run() {
                try {
                    Thread.sleep(1000)
                    val intent = Intent(baseContext, CurrentCovidActivity::class.java)
                    startActivity(intent)
                }
                catch (e : Exception)
                {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    fun setLogo()
    {
        requestManager
            .load(logo)
            .into(findViewById(R.id.splash_logo) as ImageView)
    }
}