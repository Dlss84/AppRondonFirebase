package sebastiani.app_rondon.Intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*
import sebastiani.app_rondon.Login.LoginActivity
import sebastiani.app_rondon.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val clinicaAnimation=AnimationUtils.loadAnimation(this, R.anim.clinica_animation)
        val veterinariaAnimation=AnimationUtils.loadAnimation(this, R.anim.veterinaria_animation)
        val rondonAnimation=AnimationUtils.loadAnimation(this, R.anim.rondon_animation)

        ClinicaTopTex.startAnimation(clinicaAnimation)
        VeterinariaTopTex.startAnimation(veterinariaAnimation)
        RondonTopTex.startAnimation(rondonAnimation)

        val splashScreenTimeOut = 4000
        val homeIntent=Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            startActivity((homeIntent))
            finish()
        },splashScreenTimeOut.toLong())
    }
}