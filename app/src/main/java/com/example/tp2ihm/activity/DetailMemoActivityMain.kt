package com.example.tp2ihm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.R
import com.example.tp2ihm.fragment.DetailMemoFragment
import com.example.tp2ihm.metier.dto.MemoDTO

class DetailMemoActivityMain : AppCompatActivity() {

    companion object
    {
        const val MEMO = "memo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_memo_main)

        //com.example.tp2ihm.fragment
        val fragment = DetailMemoFragment()

        //argument MEMO
        val memoDTO: MemoDTO? = intent.getParcelableExtra<MemoDTO>(MEMO)

        //argument :
        val bundle = Bundle()
        bundle.putParcelable(DetailMemoFragment.MEMO, memoDTO)
        fragment.arguments = bundle

        //ajout
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conteneur_fragment,fragment, "tagfacultatif")
        transaction.commit()
    }
}