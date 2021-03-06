package com.example.tp2ihm.activity

import com.example.tp2ihm.adapter.MemoAdapter2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.R
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var memoAdapter: MemoAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

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

        // com.example.tp2ihm.adapter :
        memoAdapter = MemoAdapter2(listeMemo,this)
        recyclerView.adapter = memoAdapter

    }

    fun clicValider(view: View) {

        //nouveau memo
        val editTextMemo = findViewById<EditText>(R.id.input_memo)
        val saisie = editTextMemo.text.toString()
        val memo = Memo(saisie,"Default", Random.nextInt(4)+1)

        //mise à jour :
        memoAdapter.ajouterMemo(memo)

        //fin:
        recyclerView.smoothScrollToPosition(0)
        editTextMemo.setText("")
    }
}