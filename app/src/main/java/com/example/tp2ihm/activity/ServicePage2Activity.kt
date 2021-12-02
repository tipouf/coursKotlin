package com.example.tp2ihm.activity

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import com.example.tp2ihm.R
import com.example.tp2ihm.service.MonService

class ServicePage2Activity : AppCompatActivity() {

    // Référence :
    private var monService: MonService? = null

    // Callback pour le binding, via un ServiceConnection :
    private val connexion: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, binder: IBinder) {
            monService = (binder as MonService.MonBinder).service
        }

        override fun onServiceDisconnected(className: ComponentName) {
            monService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_page2)



    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MonService::class.java)
        applicationContext.bindService(intent, connexion, BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        monService?.run { applicationContext.unbindService(connexion) }
    }

    fun incrementValue(view: android.view.View)
    {
        val compteur = findViewById<Button>(R.id.compteur)
        compteur.text = monService?.incrementNumber().toString()
    }
}