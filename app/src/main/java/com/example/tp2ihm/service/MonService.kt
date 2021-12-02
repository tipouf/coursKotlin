package com.example.tp2ihm.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MonService : Service() {

    companion object {
        private const val TAG = "MonService"
    }

    var number = 0
    // Binder:
    private val binder: IBinder = MonBinder()

    //MonBinder :
    inner class MonBinder : Binder()
    {
        val service = this@MonService
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

    }

    fun arreter()  = stopSelf()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "StartCommand: $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "onDestroy")
    }

    fun incrementNumber():Int
    {
        number++
        return number
    }

}