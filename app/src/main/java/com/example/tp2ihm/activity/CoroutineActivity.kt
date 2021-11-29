package com.example.tp2ihm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tp2ihm.R
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.math.ceil
import kotlin.math.sqrt

class CoroutineActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "CoroutineActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

    }

    fun checkNumber(view: View) {
        val number = findViewById<EditText>(R.id.nombre_entier)
        val num = number.text.toString().toLong()

        CoroutineScope(IO).launch {
            val max = ceil(sqrt(num.toDouble())).toLong()
            for (a in 2..max) {
                if (num % a == 0L) {
                    withContext(Main) {
                        Toast.makeText(view.context, "FALSE", Toast.LENGTH_LONG).show()
                    }
                }
                if (num % a != 0L) {
                    withContext(Main) {
                        Toast.makeText(view.context, "TRUE", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }
}