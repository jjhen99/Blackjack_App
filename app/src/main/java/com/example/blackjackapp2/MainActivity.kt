package com.example.blackjackapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var decision:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testText = findViewById<TextView>(R.id.textView)
        val cashText = findViewById<TextView>(R.id.cashText)
        val winsText = findViewById<TextView>(R.id.winsText)
        val lossesText = findViewById<TextView>(R.id.lossesText)
        val pushesText = findViewById<TextView>(R.id.pushText)
        val hit = findViewById<Button>(R.id.hitButton)
        val stand = findViewById<Button>(R.id.standButton)
        val dealerCards = findViewById<TextView>(R.id.dealerCards)
        val playerCards = findViewById<TextView>(R.id.playerCards)
        val statementText = findViewById<TextView>(R.id.statementText)
        var startRoundButton = findViewById<Button>(R.id.startRoundButton)
        var hitButton = findViewById<Button>(R.id.hitButton)
        var standButton = findViewById<Button>(R.id.standButton)


        cashText.text = "You have " + Game().cash.toString() + "$."
        winsText.text = "Wins: " + Game().wins.toString()
        lossesText.text = "Losses: " + Game().losses.toString()
        pushesText.text = "Push: " + Game().pushes.toString()
        statementText.text = "Welcome to BlackJack"
        //dealerCards.text = dealer.printFirstHand()
        //playerCards.text = player.printHand()

        hitButton.setOnClickListener {
            decision = 1
            testText.text = decision.toString()
        }

        standButton.setOnClickListener {
            decision = 2
            testText.text = decision.toString()
        }

    }
}