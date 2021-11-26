package com.example.tp2ihm.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.R
import com.example.tp2ihm.activity.DetailMemoActivityMain
import com.example.tp2ihm.activity.RecyclerViewActivity
import com.example.tp2ihm.activity.RoomMemoActivity
import com.example.tp2ihm.bo.Memo
import com.example.tp2ihm.fragment.DetailMemoFragment
import com.example.tp2ihm.metier.dto.MemoDTO

class MemoAdapterRoom  (private var listeMemoDTO: MutableList<MemoDTO>, private val roomMemoActivity: RoomMemoActivity) :
    RecyclerView.Adapter<MemoAdapterRoom.MemoViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val viewMemo = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(viewMemo)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.textViewTitleMemo.text = listeMemoDTO[position].title
        holder.textViewMemoPriority.text = listeMemoDTO[position].priority.toString()
    }

    override fun getItemCount(): Int = listeMemoDTO.size

    fun updateMemos(listeMemoDTO: MutableList<MemoDTO>)
    {
    this.listeMemoDTO = listeMemoDTO
        notifyDataSetChanged()
    }

    // ViewHolder :
    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewTitleMemo: TextView = itemView.findViewById(R.id.title_memo)
        val textViewMemoPriority: TextView = itemView.findViewById(R.id.memo_priority)

        init {
            itemView.setOnClickListener {
                val memoDTO = listeMemoDTO[adapterPosition]

                //choix affichage tablette /smartphone
                if (roomMemoActivity.findViewById<FrameLayout>(R.id.conteneur_fragment) != null) {
                    //tablette:
                    val fragment = DetailMemoFragment()

                    //argument :
                    val bundle = Bundle()
                    bundle.putParcelable(DetailMemoFragment.MEMO, memoDTO)
                    fragment.arguments = bundle

                    //ajout
                    val transaction = roomMemoActivity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.conteneur_fragment, fragment, "tagfacultatif")
                    transaction.commit()
                } else {
                    //smartphone:
                    //Envoi vers la page detail
                    Log.d("test", "test $memoDTO")
                    val intent = Intent(itemView.context, DetailMemoActivityMain::class.java)
                    intent.putExtra(DetailMemoActivityMain.MEMO, memoDTO)
                    itemView.context.startActivity(intent)
                }

            }
            }
        }
    }
