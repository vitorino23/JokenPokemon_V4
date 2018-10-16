package br.com.vitorcesario.jokenpokemon

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var vidas = 3
    var vitorias = 0

    val AGUA = 3
    val FOGO = 2
    val GRAMA = 1

    var numeroAleatorio: Random? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        numeroAleatorio = Random()

        ivAgua.setOnClickListener {
            ivJogador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.squirtle))
            realizarJogada(AGUA)
        }

        ivFogo.setOnClickListener {
            ivJogador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.charmander))
            realizarJogada(FOGO)
        }
        ivGrama.setOnClickListener {
            ivJogador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bulbasaur))
            realizarJogada(GRAMA)
        }

        if (vidas == 0){
            val intent = Intent(this, GameOverActivity::class.java)
            startActivity(intent)
        }
    }

    fun realizarJogada(jogadaPlayer: Int){
        //val player = MediaPlayer.create(this, R.raw.jokenpo)
        //player.start()

        val jogadaPC = numeroAleatorio!!.nextInt(3) + 1

        when (jogadaPC){
            AGUA -> {
                ivComputador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.squirtle))
                when(jogadaPlayer){
                    GRAMA -> venceu()
                    AGUA -> empatou()
                    FOGO -> perdeu()
                }
            }
            GRAMA -> {
                ivComputador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bulbasaur))
                when(jogadaPlayer){
                    GRAMA -> empatou()
                    AGUA -> perdeu()
                    FOGO -> venceu()
                }
            }
            FOGO -> {
                ivComputador!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.charmander))
                when(jogadaPlayer){
                    GRAMA -> perdeu()
                    AGUA -> venceu()
                    FOGO -> empatou()
                }
            }
        }
    }
    fun venceu(){
        resultado!!.text = "Venceu";
        resultado!!.setTextColor(ContextCompat.getColor(this, R.color.Vitoria))
        vitorias += 1
    }

    fun perdeu(){
        resultado!!.text = "Perdeu";
        resultado!!.setTextColor(ContextCompat.getColor(this, R.color.Derrota))
        vidas -= 1
    }

    fun empatou() {
        resultado!!.text = "Empatou";
        resultado!!.setTextColor(ContextCompat.getColor(this, R.color.Empate))
    }
}
