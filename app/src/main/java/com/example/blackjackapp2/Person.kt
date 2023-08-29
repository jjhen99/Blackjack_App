package com.example.blackjackapp2

open class Person {

    private var hand: Hand
    private var name: String

    constructor(){
        this.hand = Hand()
        this.name = ""
    }

    open fun getHand(): Hand {return this.hand} //NOTE: Could be error here

    open fun setHand(hand: Hand){
        this.hand = hand
    }

    open fun getName(): String {//Check here for errors
        return this.name
    }

    open fun setName(name:String){
        this.name = name
    }


    //This section was changed, need to test. 22/08/23 works for now but need to check later.
    open fun hasBlackJack(): Boolean{
        return this.getHand().calculatedValue()==21
    }

    open fun printHand(): String {
        //Need to figure out how to print.
        //Can run a test
        return this.name + "'s hand looks like this:\n" + this.hand.toString() + "Valued at: " + this.hand.calculatedValue()
    }
//edit in deck
     open fun hit(deck:Deck, discard:Deck){
        if (!deck.hasCards()){
            deck.reloadDeckFromDiscard(discard)

        }
        this.hand.takeCardFromDeck(deck)
        println(this.name + " gets a card")
        this.printHand()
    }

    open fun stand():String{ //this stand function is not in the original code
        return "You stand."  // This method could be used for the button perhaps.
                            //Will need editing later
    }


}