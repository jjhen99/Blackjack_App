package com.example.blackjackapp2

class Card {
    //returns a suit
    //vars
    private var suit: Suit

    private var rank: Rank


    //create a card with a given suit and rank
    constructor (suit: Suit, rank: Rank) {
        this.suit = suit
        this.rank = rank
    }



    fun getValue(): Int{
        return rank.rankValue
    }

    private fun getSuit(): Suit{
        return suit
    }

    private fun getRank(): Rank{
        return rank
    }

    override fun toString(): String {
        return "[" + rank + " of " + suit + "] (" + getValue() + ")"
    }

    constructor(card: Card) {
        suit = card.getSuit()
        rank = card.getRank()
    }
}