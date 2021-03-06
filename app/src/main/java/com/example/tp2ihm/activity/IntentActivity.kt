package com.example.tp2ihm.activity

import android.Manifest
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Button
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tp2ihm.R

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bouton: Button
    private lateinit var boutonSend: Button
    private lateinit var boutonSend2: Button
    private lateinit var boutonPermission: Button
    private lateinit var boutonRecycler: Button
    private lateinit var boutonFragment: Button
    private lateinit var boutonPreference: Button
    private lateinit var boutonDispositon: Button
    private lateinit var boutonRoom: Button
    private lateinit var boutonContentProvider: Button
    private lateinit var boutonCoroutine: Button
    private lateinit var boutonWebService: Button
    private lateinit var boutonDataBinding: Button
    private lateinit var  boutonViewModel: Button
    private lateinit var  boutonListAdapter: Button
    private lateinit var  boutonService: Button
    private lateinit var  boutonBroadcast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)



        bouton = findViewById<Button>(R.id.buttonIntent)
        bouton.setOnClickListener(this)

        boutonSend = findViewById<Button>(R.id.buttonSend)
        boutonSend.setOnClickListener(this)

        boutonSend2 = findViewById<Button>(R.id.buttonSend2)
        boutonSend2.setOnClickListener(this)

        boutonPermission = findViewById<Button>(R.id.buttonPermission)
        boutonPermission.setOnClickListener(this)

        boutonRecycler = findViewById<Button>(R.id.buttonRecycler)
        boutonRecycler.setOnClickListener(this)

        boutonFragment = findViewById<Button>(R.id.buttonFragment)
        boutonFragment.setOnClickListener(this)

        boutonPreference = findViewById<Button>(R.id.buttonPreferences)
        boutonPreference.setOnClickListener(this)

        boutonDispositon = findViewById<Button>(R.id.button_disposition)
        boutonDispositon.setOnClickListener(this)

        boutonRoom = findViewById<Button>(R.id.buttonRoom)
        boutonRoom.setOnClickListener(this)

        boutonContentProvider = findViewById<Button>(R.id.buttonContentProvider)
        boutonContentProvider.setOnClickListener(this)

        boutonCoroutine = findViewById<Button>(R.id.buttonCoroutine)
        boutonCoroutine.setOnClickListener(this)

        boutonWebService = findViewById<Button>(R.id.buttonWebservice)
        boutonWebService.setOnClickListener(this)

        boutonDataBinding = findViewById<Button>(R.id.buttonDataBinding)
        boutonDataBinding.setOnClickListener(this)

        boutonViewModel = findViewById<Button>(R.id.buttonViewModel)
        boutonViewModel.setOnClickListener(this)

        boutonListAdapter = findViewById<Button>(R.id.buttonlistAdapter)
        boutonListAdapter.setOnClickListener(this)

        boutonService = findViewById<Button>(R.id.button_service)
        boutonService.setOnClickListener(this)

        boutonBroadcast = findViewById<Button>(R.id.button_broadcast)
        boutonBroadcast.setOnClickListener(this)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onClick(view: View?) {
        if (view == bouton) {
            val intent = Intent(this, Cycledevie::class.java)
            intent.putExtra("name", "Rodolphe")
            startActivity(intent)

        } else if (view == boutonSend) {

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Voici le message")
            intent.type = "text/plain"

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        } else if (view == boutonSend2) {

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "et encore un autre message")
            intent.type = "text/plain"

            val chooser = Intent.createChooser(intent, "Envoyer ?? pepito")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        } else if (view == boutonPermission) {
            // on verifie la permission
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
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    123
                )
            }
        } else if (view == boutonRecycler) {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        } else if (view == boutonFragment) {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        } else if (view == boutonPreference) {
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        } else if (view == boutonDispositon) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else if (view == boutonRoom) {
            val intent = Intent(this, RoomMemoActivity::class.java)
            startActivity(intent)
        } else if (view == boutonContentProvider) {
            val intent = Intent(this, ContentProviderActivity::class.java)
            startActivity(intent)
        } else if (view == boutonCoroutine) {
            val intent = Intent(this, CoroutineActivity::class.java)
            startActivity(intent)
        } else if (view == boutonWebService) {
            val intent = Intent(this, WebServiceActivity::class.java)
            startActivity(intent)
        } else if (view == boutonDataBinding) {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        } else if (view == boutonViewModel) {
            val intent = Intent(this, ViewModelLiveData::class.java)
            startActivity(intent)
        } else if (view == boutonListAdapter) {
            val intent = Intent(this, ListAdapterActivity::class.java)
            startActivity(intent)
        } else if (view == boutonService) {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }else if (view == boutonBroadcast) {
            val intent = Intent(this, BroadcastActivity::class.java)
            startActivity(intent)
        }
    }
        private fun lireContact() {
            Toast.makeText(this, "contacts", Toast.LENGTH_LONG).show()
        }
    }


