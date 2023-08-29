package com.example.blackjackapp2

enum class Suit(var suitName: String) {
    //Contains card suits and names
    CLUB("Clubs"), DIAMOND("Diamonds"), HEART("Hearts"), SPADE("Spades");

    override fun toString(): String {
        return suitName
    }
}