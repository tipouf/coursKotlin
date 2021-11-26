package com.example.tp2ihm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tp2ihm.R
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.metier.dto.MemoDTO

class DetailMemoFragmentOld : Fragment() {

    companion object
    {
        const val MEMO = "memo"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this com.example.tp2ihm.fragment
        return inflater.inflate(R.layout.fragment_detail_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //arguments :
        val arguments: Bundle = requireArguments()
        val memo: Memo? = arguments.getParcelable(MEMO)

        //Affichage :
        val textViewMemoDetail = view.findViewById<TextView>(R.id.detail_memo)
        textViewMemoDetail.text = memo.toString()
    }
}