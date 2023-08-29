package com.example.blackjackapp2

import java.util.Scanner


//Player Class might not be needed
//Rewrite code makeDecision in main

class Player: Person() {
    var input = Scanner(System.`in`)


    //Normally there would be a Scanner here,
    //Will need to use a Button instead OR
    //Use a kotlin version of a scanner
    //Need to check button input

    init {
        super.setName("Player")
    }

    fun makeDecision(deck: Deck, discard: Deck) {
        var decision: Int
        Game().statement=("Would you like to: Hit or Stand");
        decision = MainActivity().decision;


        if (decision == 1) {
            //hit deck using deck and discard deck
            this.hit(deck, discard);
            //return(exit method) if they have black or bust
            if(this.getHand().calculatedValue()>20){
                return;
            }
            //if they didnt bust or get 21, allow to decide to hit or stand again by going back to same method
            else{
                this.makeDecision(deck, discard);
            }

            //if they type any number other than 1, they're standing

        }
        else if(decision == 2){
            System.out.println("You stand.");

        }
        //Need to change the makeDecision method

    }
}