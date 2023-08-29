package com.example.blackjackapp2

import java.util.Collections
import java.util.Random
import java.util.ArrayList


class Deck {
    private var deck = ArrayList<Card>()

    constructor(){
        deck = ArrayList<Card>()
    }

    fun addCard(card: Card) {

        deck.add(card)
    }

    override fun toString(): String {
        var output: String = ""

        //for each Card "card" in the deck
        //for each Card "card" in the deck
        for (card:Card in deck) {
            //add card and escape charcter for new line
            output += card
            output += "\n"
        }

        return output
    }

    constructor(makeDeck: Boolean) {
        deck = ArrayList()
        if (makeDeck) {
            //GO through all suits - for each suit in suit.values
            for (suit:Suit in Suit.values()) {
                //Go through all ranks - for each rank in rank.values
                for (rank:Rank in Rank.values()) {
                    //add a new card containing each iterations suit and rank
                    deck.add(Card(suit, rank))
                }
            }
        }
    }

    fun shuffle() { //This returns nothing
        deck.shuffle(Random())
    }

    //takeCard section has had changes, test to see if it works.

    fun takeCard():Card{
        var cardToTake:Card = Card(deck[0])
        deck.removeAt(0)
        return cardToTake;

    }

    fun hasCards():Boolean{
        return deck.size >0 //Check this line for errors
        //run a test
    }

    fun getCards():ArrayList<Card>{
        return deck
    }

    fun emptyDeck(){
        deck.clear()
    }

    fun addCards(cards: ArrayList<Card>){
        deck.addAll(cards)
    }

    fun reloadDeckFromDiscard(discard:Deck){
        this.addCards(discard.getCards())
        this.shuffle()
        discard.emptyDeck()
        println("Ran out of cards, creating new deck from discard pile and shuffling deck.")
    }

    fun cardsLeft():Int{
        return deck.size
    }
}