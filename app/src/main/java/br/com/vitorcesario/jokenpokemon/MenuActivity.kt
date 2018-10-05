package br.com.vitorcesario.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btJogar.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        btSobre.setOnClickListener {
            val intent = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }

        btSair.setOnClickListener {
            finish()
        }
    }


}
