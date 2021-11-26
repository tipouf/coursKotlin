package com.example.tp2ihm.adapter

import com.example.tp2ihm.activity.DetailMemoActivityMain
import com.example.tp2ihm.activity.FragmentActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.R
import com.example.tp2ihm.activity.DetailMemoActivityMainOld
import com.example.tp2ihm.fragment.DetailMemoFragment
import com.example.tp2ihm.fragment.DetailMemoFragmentOld

class MemoAdapter (private var listeMemo: MutableList<Memo>, private val fragmentActivity: FragmentActivity) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val viewMemo = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(viewMemo)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.textViewTitleMemo.text = listeMemo[position].title
        holder.textViewMemoPriority.text = listeMemo[position].priority.toString()
    }

    override fun getItemCount(): Int = listeMemo.size

    fun ajouterMemo(memo: Memo){
        listeMemo.add(0,memo)
        notifyItemInserted(0)

    }

    // ViewHolder :
    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewTitleMemo: TextView = itemView.findViewById(R.id.title_memo)
        val textViewMemoPriority: TextView = itemView.findViewById(R.id.memo_priority)

        init {
            itemView.setOnClickListener{
                val memo = listeMemo[adapterPosition]

                val preferences = PreferenceManager.getDefaultSharedPreferences(itemView.context)
                val editor = preferences.edit()
                editor.putString("memoSave", memo.title)
                editor.apply()

                //choix affichage tablette /smartphone
                if (fragmentActivity.findViewById<FrameLayout>(R.id.conteneur_fragment) != null)
                {
                    //tablette:
                    val fragment = DetailMemoFragmentOld()

                    //argument :
                    val bundle = Bundle()
                    bundle.putParcelable(DetailMemoFragmentOld.MEMO, memo)
                    fragment.arguments = bundle

                    //ajout
                    val transaction = fragmentActivity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.conteneur_fragment,fragment, "tagfacultatif")
                    transaction.commit()
                } else {
                    //smartphone:
                    //Envoi vers la page detail
                    Log.d("test", "test $memo")
                    val intent = Intent(itemView.context,DetailMemoActivityMainOld::class.java)
                    intent.putExtra(DetailMemoActivityMainOld.MEMO, memo)
                    itemView.context.startActivity(intent)
                }




            }
        }
    }
}