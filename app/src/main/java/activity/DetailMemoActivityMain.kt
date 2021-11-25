package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bo.Memo
import com.example.tp2ihm.R
import fragment.DetailMemoFragment

class DetailMemoActivityMain : AppCompatActivity() {

    companion object
    {
        const val MEMO = "memo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_memo_main)

        //fragment
        val fragment = DetailMemoFragment()

        //argument MEMO
        val memo: Memo? = intent.getParcelableExtra<Memo>(MEMO)

        //argument :
        val bundle = Bundle()
        bundle.putParcelable(DetailMemoFragment.MEMO, memo)
        fragment.arguments = bundle

        //ajout
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conteneur_fragment,fragment, "tagfacultatif")
        transaction.commit()
    }
}