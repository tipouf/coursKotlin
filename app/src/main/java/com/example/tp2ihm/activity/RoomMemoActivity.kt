package com.example.tp2ihm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.R
import com.example.tp2ihm.adapter.MemoAdapter
import com.example.tp2ihm.adapter.MemoAdapterRoom
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.metier.bdd.AppDatabaseHelper
import com.example.tp2ihm.metier.dto.MemoDTO
import kotlin.random.Random

class RoomMemoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var memoAdapter: MemoAdapterRoom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_memo)

        //creation de la base de données
        AppDatabaseHelper.getDatabase(this).memosDAO().getListeMemos()


        //share preferences
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val valeur = preferences.getString("memoSave", "NO SAVE YET")
        Toast.makeText(this,valeur.toString(), Toast.LENGTH_LONG).show()

        // liste :
        recyclerView = findViewById(R.id.listeItem)

        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true)

        // layout manager, décrivant comment les items sont disposés :
        recyclerView.layoutManager = LinearLayoutManager(this)

        // contenu d'exemple :
        val listeMemo: MutableList<Memo> = ArrayList()
        listeMemo.add(Memo("rappel", "rendez vous urgent", 5))
        listeMemo.add(Memo("Dentiste", "demain soir 17h30", 1))

        for (a in 1..100){
            listeMemo.add(Memo("Rappel Urgent $a", "rappel rappel rappel rappel $a", Random.nextInt(4)+1))
        }

        // récupérer une liste de Memos :
        val listeMemoDTO: MutableList<MemoDTO> = AppDatabaseHelper.getDatabase(this)
            .memosDAO()
            .getListeMemos()

        // com.example.tp2ihm.adapter :
        memoAdapter = MemoAdapterRoom(listeMemoDTO, this)
        recyclerView.adapter = memoAdapter

    }

    fun clicValider(view: View) {

        //nouveau memo
        val editTextMemo = findViewById<EditText>(R.id.input_memo)
        val saisie = editTextMemo.text.toString()
        val memoDTO = MemoDTO(0,saisie,"contenu par default",Random.nextInt(1,5))

        //mise à jour :
        //memoAdapter.ajouterMemo(memo)

        //creation d'un memoDTO
        AppDatabaseHelper.getDatabase(this).memosDAO().insert(memoDTO)

        // récupérer une liste de Memos :
        val listeMemoDTO: MutableList<MemoDTO> = AppDatabaseHelper.getDatabase(this)
            .memosDAO()
            .getListeMemos()

        // mise a jour de la liste
        memoAdapter.updateMemos(listeMemoDTO)

        //fin:
        recyclerView.smoothScrollToPosition(0)
        editTextMemo.setText("")
    }
}