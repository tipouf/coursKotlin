package com.example.tp2ihm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.example.tp2ihm.R
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.random.Random

class PreferencesActivity : AppCompatActivity() {

    companion object
    {
        private const val CLESHARE = "cleshare"
        private const val TXTFILE = "hello_file.txt"
        private const val CONTENT = "HELLO WORLD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
    }

    fun saveSharePreference(view: android.view.View) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()
        editor.putInt(CLESHARE, Random.nextInt(1,100))
        editor.apply()
    }

    fun readSharePreference(view: android.view.View) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val valeur = preferences.getInt(CLESHARE, 0)
        Toast.makeText(this, valeur.toString(), Toast.LENGTH_LONG).show()
    }

    fun saveTXT(view: android.view.View) {

// écriture (utiliser MODE_APPEND si écriture à la suite) :
        val stream: FileOutputStream = openFileOutput(TXTFILE, MODE_PRIVATE)
        stream.write(CONTENT.toByteArray())
        stream.close()
    }

    fun readTXT(view: android.view.View) {
        // initialisation :
        val stream: FileInputStream = openFileInput(TXTFILE)
        val stringBuilder = StringBuilder()
        val buffer = ByteArray(1024)
// lecture :
        while (stream.read(buffer) != -1)
        {
            stringBuilder.append(String(buffer))
        }
        stream.close()
// affichage :
        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show()
    }
}