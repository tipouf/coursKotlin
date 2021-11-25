package adapter

import activity.DetailMemoActivityMain
import activity.FragmentActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bo.Memo
import com.example.tp2ihm.R
import fragment.DetailMemoFragment

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

                //choix affichage tablette /smartphone
                if (fragmentActivity.findViewById<FrameLayout>(R.id.conteneur_fragment) != null)
                {
                    //tablette:
                    val fragment = DetailMemoFragment()

                    //argument :
                    val bundle = Bundle()
                    bundle.putParcelable(DetailMemoFragment.MEMO, memo)
                    fragment.arguments = bundle

                    //ajout
                    val transaction = fragmentActivity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.conteneur_fragment,fragment, "tagfacultatif")
                    transaction.commit()
                } else {
                    //smartphone:
                    //Envoi vers la page detail
                    Log.d("test", "test $memo")
                    val intent = Intent(itemView.context,DetailMemoActivityMain::class.java)
                    intent.putExtra(DetailMemoActivityMain.MEMO, memo)
                    itemView.context.startActivity(intent)
                }




            }
        }
    }
}