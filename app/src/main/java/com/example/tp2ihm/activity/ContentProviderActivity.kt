package com.example.tp2ihm.activity

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tp2ihm.R
import com.example.tp2ihm.metier.dao.ContactsDAO

class ContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_CONTACTS
        )
        if (permission == PackageManager.PERMISSION_GRANTED) {
            lireContact()
        } else {
            // affichage de la popup de demande de permission :
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),123)
        }

        fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults:IntArray)
        {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         if(requestCode == 123){
             if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                lireContact()
             } else {
                Toast.makeText(this, "Autorisation Refusée", Toast.LENGTH_LONG).show()
             }
         }
        }
    }

    private fun lireContact() {

        //vue :
        val textViewContacts = findViewById<TextView>(R.id.contacts)

        //contacts :
        val listContacts = ContactsDAO.getListeContacts(this)

        // affichage :
        val stringBuilder = StringBuilder()
        if(listContacts.isNotEmpty()) {
            for (contact in listContacts) {
                stringBuilder.append(contact.nom).append(" : ").append(contact.numero).append("\n")
            }
            } else {
            stringBuilder.append("no contacts")
        }
        textViewContacts.text = stringBuilder.toString()
    }

    fun lireContactContentProvider(view: View) {

        //vue :
        val textViewContacts = findViewById<TextView>(R.id.contacts)

        //contacts :
        val listContacts = ContactsDAO.getListeContacts(this)

        // affichage :
        val stringBuilder = StringBuilder()
        if(listContacts.isNotEmpty()) {
            for (contact in listContacts) {
                stringBuilder.append(contact.nom).append(" : ").append(contact.numero).append("\n")
            }
        } else {
            stringBuilder.append("no contacts")
        }
        textViewContacts.text = stringBuilder.toString()
    }
}