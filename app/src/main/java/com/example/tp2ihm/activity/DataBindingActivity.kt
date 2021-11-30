package com.example.tp2ihm.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tp2ihm.R
import com.example.tp2ihm.bo.Contact
import com.example.tp2ihm.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var adb: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contact = Contact("cindon","0611111111")
        adb = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        adb.contact = contact

        adb.buttonUpdate.setOnClickListener {
            Toast.makeText(this, "contact mis a jour: ${adb.editNom.text}", Toast.LENGTH_LONG)
                .show()
            adb.nom.text = adb.editNom.text
            adb.numero.text = adb.editNumero.text
        }

    }




}