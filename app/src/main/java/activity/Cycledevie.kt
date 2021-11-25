package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tp2ihm.R
import kotlin.random.Random

class Cycledevie : AppCompatActivity() {

    private var dice1 = 1
    private var dice2 = 1
    private var dice3 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycledevie)

        //reception
        val valeur = intent.getStringExtra("name")

            dice1 = savedInstanceState?.getInt("dice1") ?: Random.nextInt(5)+1
            dice2 = savedInstanceState?.getInt("dice2") ?: Random.nextInt(5)+1
            dice3 = savedInstanceState?.getInt("dice3") ?: Random.nextInt(5)+1

        Toast.makeText(this, "bonjour: $valeur", Toast.LENGTH_LONG).show()

        val button1 = findViewById<Button>(R.id.button1)
        button1.text = dice1.toString()
        val button2 = findViewById<Button>(R.id.button2)
        button2.text = dice2.toString()
        val button3 = findViewById<Button>(R.id.button3)
        button3.text = dice3.toString()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("dice1", dice1)
        outState.putInt("dice2", dice2)
        outState.putInt("dice3", dice3)

        super.onSaveInstanceState(outState)
    }
}