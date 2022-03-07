package games;

import java.util.ArrayList;

public class CardsGame {

	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<Card>();
		
		String[] name = {"SPADE", "HEART", "DIAMOND", "CLUB"};
	    for(String n : name){
	        for(int card_number = 1; card_number <= 13; card_number++){
	            cards.add(new Card(n, card_number));
	        }
	    }
	    
	    Shuffle shuffle = new Shuffle();
	    shuffle.run_infinite(cards);

		
	}

}