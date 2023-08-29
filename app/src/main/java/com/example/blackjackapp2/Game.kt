package com.example.blackjackapp2

import androidx.appcompat.app.AppCompatActivity

class Game {
    var cash:Int

    //Set score to 0
    var wins:Int
    var losses:Int
    var pushes:Int

    var dealer: Dealer = Dealer()
    var player: Player = Player()

    var deck:Deck
    var discarded:Deck
    var statement:String //This will be used to return whether player has won or lost

    init {
        cash = 100
        wins = 0
        losses = 0
        pushes = 0
        statement = ""

        //Set cash to 100 dollars


        //create people


        //Shuffle deck and start first round
        deck = Deck(true)
        discarded = Deck()
        deck.shuffle()
        startRound()
    }

    private fun startRound(): String {
        if(cash>0){
            if( wins> 0 || losses>0 || pushes > 0){
                println();
                println("Starting next round...Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
                dealer.getHand().discardHandToDeck(discarded);
                player.getHand().discardHandToDeck(discarded);
            }

            if(deck.cardsLeft()<4){
                deck.reloadDeckFromDiscard(discarded)
            }

            //set up bet
            var bet:Int = 0
            var getBet:Boolean = true

            /*while(getBet){
                try {
                    println("How much would you like to bet?")
                    bet = betInput.nextInt()
                    while (bet > cash) { //Makes sure the bet input is less than the amount of cash the player has.
                        println("You don't have enough cash, choose a lower number.")
                        bet = betInput.nextInt()
                    }
                    getBet = false
                } catch (e: Exception) {
                    println("Invalid bet input.")
                    betInput.next()
                }
            }

            cash = cash - bet*/

            //Give dealer two cards
            dealer.getHand().takeCardFromDeck(deck)
            dealer.getHand().takeCardFromDeck(deck)

            //Give player two cards
            player.getHand().takeCardFromDeck(deck)
            player.getHand().takeCardFromDeck(deck)

            //print hands
            dealer.printFirstHand()
            player.printHand()

            //Check if dealer has blackjack
            if (dealer.hasBlackJack()){
                dealer.printHand();

                if (player.hasBlackJack()){
                    pushes++
                    statement = "You both have 21 - Push." // Need to figure out how to return this
                    //startRound()
                }
                else{
                    statement = "Dealer has BlackJack. You lose."
                    dealer.printHand()
                    losses++
                    //startRound()
                }


            }

            //Check fi player has blackjack
            if(player.hasBlackJack()){
                statement = "You have BlackJack!"
                wins ++
                //startRound()
            }
            //player.makeDecision(deck,discarded)

            if (player.getHand().calculatedValue() > 21){
                statement ="You have gone over 21."
                losses++

                //startRound()
            }
            dealer.printHand()
            while (dealer.getHand().calculatedValue()< 17){
                dealer.hit(deck,discarded)
            }

            //Check who wins
            if (dealer.getHand().calculatedValue() > 21){
                statement = "Dealer busts"
                wins++
            }
            else if(dealer.getHand().calculatedValue()> player.getHand().calculatedValue()){
                statement = "You lose"
                losses++
            }
            else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
                statement = "You win"
                wins++
            }
            else{
                statement = "Push"
                pushes++
            }

            //startRound()


        }

        //return statement //not sure if this will work, need to do test

    }

}