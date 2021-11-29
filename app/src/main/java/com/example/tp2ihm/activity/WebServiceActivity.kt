package com.example.tp2ihm.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tp2ihm.R
import com.example.tp2ihm.ws.ReseauHelper
import com.example.tp2ihm.ws.RetrofitSingleton
import com.example.tp2ihm.ws.WSInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import kotlin.Exception
import kotlin.random.Random

class WebServiceActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "tag ws"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
    }

    fun getPlanet(view: View) {

        val result = findViewById<TextView>(R.id.result)
        //verifier connexion internet
        if (!ReseauHelper.estConnecte(this)){
            Toast.makeText(this, "Aucune connexion internet",Toast.LENGTH_LONG).show()
            return
        }

        //coroutine
        CoroutineScope(Dispatchers.IO).launch {

            //appel synchrone get service
            val service = RetrofitSingleton.retrofit.create(WSInterface::class.java)
            try {
                val planeteSizeList = service.getAllPlanets()
                Log.i(TAG, planeteSizeList.toString())

                val num = Random.nextInt(1, planeteSizeList.count)
                try {
                    Log.i(TAG, num.toString())
                    val planet = service.getOnePlanet(num)
                    Log.i(TAG, planet.toString())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(view.context, "planete: $planet", Toast.LENGTH_LONG).show()
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            } catch (e: Exception){
                e.printStackTrace()
            }



        }

    /*
        // appeler webservice
        val service = RetrofitSingleton.retrofit.create(WSInterface::class.java)
        val call = service.getPlanet()
        call.enqueue(object:Callback<Planet>{
            override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                if (response.isSuccessful){
                    val planet =  response.body()
                    Log.i(TAG, "PLANET ${planet.toString()}")

                }
            }

            override fun onFailure(call: Call<Planet>, t: Throwable) {
                t.printStackTrace()
            }
        }) */

    }
}