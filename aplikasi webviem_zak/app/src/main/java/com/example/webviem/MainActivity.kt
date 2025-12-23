package com.example.webviem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var txtTime: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTime = findViewById(R.id.txtTime)
        startClock()
    }

    private fun startClock() {
        handler.post(object : Runnable {
            override fun run() {
                val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
                txtTime.text = time
                handler.postDelayed(this, 1000)
            }
        })
    }

    fun openFacebook(view: View) {
        openUrl("https://www.facebook.com")
    }

    fun openYoutube(view: View) {
        openUrl("https://www.youtube.com")
    }

    fun openInstagram(view: View) {
        openUrl("https://www.instagram.com")
    }

    fun openTiktok(view: View) {
        openUrl("https://www.tiktok.com")
    }

    private fun openUrl(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}