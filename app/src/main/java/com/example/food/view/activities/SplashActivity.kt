package com.example.food.view.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.food.R
import com.example.food.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //using viewBinding
        val splashBinding:ActivitySplashBinding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)



        //splashBinding.SplashScreenText.text="Hello World"
        //code to remove notification panel while displaying splash screen


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            @Suppress("DEPRECATION")
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }





        //configuring the splash animation


        val splashAnimation=AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        splashBinding.SplashScreenText.animation=splashAnimation






        //starting the main activity after the splash animation


        splashAnimation.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                },1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })


    }

    }
