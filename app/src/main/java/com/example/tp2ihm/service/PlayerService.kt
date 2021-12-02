package com.example.tp2ihm.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.tp2ihm.activity.BroadcastActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PlayerService : Service()
{
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        play()
        return START_STICKY
    }


    private fun play()
    {
        CoroutineScope(Dispatchers.IO).launch{
            for (a in 0..30){
                //PAUSE
                delay(1000)

                //emettre progression lecture:
                val intent = Intent()
                intent.action = BroadcastActivity.MonBroadcastReceiver.INTENT_FILTER
                intent.putExtra(
                    BroadcastActivity.MonBroadcastReceiver.EXTRA_PROGRESSION,
                    a)
                sendBroadcast(intent)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? = null
}