package games;

import java.util.ArrayList;

public class CardsGame {

	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<Card>(); // declaring an ArrayList of type Card

		String[] name = { "s", "h", "d", "c" }; // s represents spade, h represents heart, d represents diamond, c represents club
		for (String n : name) { // adding 52 playing cards in the ArrayList of cards
			for (int card_number = 1; card_number <= 13; card_number++) {
				cards.add(new Card(n, card_number));
			}
		}

		Shuffle shuffle = new Shuffle(); // declaring an instance of Shuffle class
		shuffle.run_infinite(cards);  // run this method until our condition will get satisfied
	}

}