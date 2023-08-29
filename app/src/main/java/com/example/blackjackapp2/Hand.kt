package com.example.blackjackapp2

class Hand {
    private var hand = ArrayList<Card>()

    fun takeCardFromDeck(deck:Deck){
        hand.add(deck.takeCard())
    }

    override fun toString():String{
        var output:String = ""
        for(card:Card in hand){
            output += card
            output += "-" //NOTE: This line has been changed
        }
        return output;
    }

    fun calculatedValue():Int {
        var value:Int = 0
        var aceCount:Int = 0

        for(card:Card in hand){
            value += card.getValue()
            if(card.getValue() == 11){
                aceCount ++
            }
        }

        if (value > 21 && aceCount > 0){
            while (aceCount>0 && value > 21){
                aceCount --
                value -= 10
            }
        }
        return value;
    }

    //Method to get first card from dealers hand
    public fun getCard(idx:Int):Card{
        return hand[idx];
    }

    fun discardHandToDeck(discardDeck:Deck){
        discardDeck.addCards(hand)

        hand.clear()
    }
}