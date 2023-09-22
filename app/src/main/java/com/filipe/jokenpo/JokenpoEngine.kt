package com.filipe.jokenpo

import androidx.drawerlayout.widget.DrawerLayout
import kotlin.random.Random

enum class Result {
    DRAW,LOSS,WIN
}

class JokenpoEngine(private val avaliablePlays:Array<String>) {

    fun calculateResult(playerPlay: String) :Result {
        val aiPlay = getAiPlay()

        return when{
            playerPlay == aiPlay -> Result.DRAW
            playerPlay =="Pedra" && aiPlay =="Papel" -> Result.LOSS
            playerPlay =="Pedra" && aiPlay =="Tesoura" -> Result.WIN
            playerPlay =="Papel" && aiPlay =="Tesoura" -> Result.LOSS
            playerPlay =="Papel" && aiPlay =="Pedra" -> Result.WIN
            playerPlay =="Tesoura" && aiPlay =="Papel" -> Result.WIN
            else -> Result.LOSS
        }
    }

    private fun  getAiPlay():String{
        val playIndex = Random.nextInt(0,2)
        return avaliablePlays[playIndex]
    }

}