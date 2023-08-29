package com.example.blackjackapp2

class Dealer : Person() {
    init {
        //name dealer "Dealer
        super.setName("Dealer") //use super because of extend - call parent class setName
    }

    //Find out what first card is, without revealing second
    //Print dealers first hand, one card face down.
    fun printFirstHand(): String {
        return "The dealer's hand looks like this:\n" + super.getHand().getCard(0) + "\nThe second card is face down."
    }
}