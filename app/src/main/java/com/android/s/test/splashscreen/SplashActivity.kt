package com.android.s.test.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : AppCompatActivity() {
    private var isCompleted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen().setKeepOnScreenCondition{
            if (isCompleted) {
                startMainActivity()
            }
            true
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            isCompleted = true
        }, 2000)
    }

    private fun startMainActivity() {
        startActivity(
            Intent(this, MainActivity::class.java)
        )
    }
}