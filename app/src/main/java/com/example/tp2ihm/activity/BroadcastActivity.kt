package com.example.tp2ihm.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tp2ihm.R
import com.example.tp2ihm.databinding.ActivityBroadcastBinding
import com.example.tp2ihm.service.PlayerService

class BroadcastActivity : AppCompatActivity()
{

    // Binding :
    private lateinit var  activityBroadcastBinding: ActivityBroadcastBinding


    //Broadcast receiver:
    private lateinit var monBroadcastReceiver: BroadcastReceiver

    // Classe broadcast receiver:
    class MonBroadcastReceiver(val broadcastActivity: BroadcastActivity) : BroadcastReceiver()
    {
        companion object
        {
            const val INTENT_FILTER = "com.exemple.MON_INTENT"
            const val EXTRA_PROGRESSION = "progression"
        }

        override fun onReceive(context: Context?, intent: Intent?)
        {
            val progression = intent?.getIntExtra(EXTRA_PROGRESSION, 0) ?: 0
            broadcastActivity.activityBroadcastBinding.progressHorizontal.progress = progression
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding:
        activityBroadcastBinding = DataBindingUtil.setContentView(this, R.layout.activity_broadcast)

        // broadcast revceiver:
        monBroadcastReceiver = BroadcastActivity.MonBroadcastReceiver(this)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(monBroadcastReceiver, IntentFilter(BroadcastActivity.MonBroadcastReceiver.Companion.INTENT_FILTER))
    }

    override fun onStop() {
        super.onStop()
    }

    fun clicButtonPlay(view: View)
    {
        val intent = Intent(this, PlayerService::class.java)
        startService(intent)
    }
}