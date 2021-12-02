package com.example.tp2ihm.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.tp2ihm.R
import com.example.tp2ihm.service.MonService

class ServiceActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        val intentService = Intent(this, MonService::class.java )
        startService(intentService)
    }

    fun changePage(view: View)
    {
        val intent = Intent(this, ServicePage2Activity::class.java)

        startActivity(intent)
    }
}