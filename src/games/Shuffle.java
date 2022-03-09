package games;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

	public void shuffle_cards(ArrayList<Card> cards, ArrayList<Player> players) {
		Random rand = new Random();
		for (int i = 0; i < cards.size(); i++) { // shuffling cards
			int r = i + rand.nextInt(cards.size() - i); // getting value of r in the range from 0 to cards.size()-i

			// swapping the elements
			Card temp = cards.get(r);
			cards.set(r, cards.get(i));
			cards.set(i, temp);
		}

		for (int i = 0; i < players.size(); i++) { // clearing all cards contained by each player so that we can assign them cards again
			players.get(i).c.clear();
		}

		int k = 0;
		for (int i = 0; i < 13; i++) { // assign the shuffled cards to each player
			for (int j = 0; j < players.size(); j++) {
				players.get(j).addCard(cards.get(k));
				k++;
			}
		}

	}

	public boolean check(ArrayList<Player> players) { // Check if each player has one spade and one face-card
		int player_found = 0;
		for (int i = 0; i < players.size(); i++) {
			boolean spade_found = false, face_found = false;
			int n = players.get(i).c.size();
			for (int j = 0; j < n; j++) {
				face_found = face_found || players.get(i).c.get(j).is_face;
				spade_found = spade_found || players.get(i).c.get(j).is_spade;
			}
			if (spade_found && face_found) {
				player_found += 1;
			}
		}
		return (player_found == 4);
	}

	public void run(ArrayList<Card> cards, ArrayList<Player> players) {
		int num = 0;
		while (!check(players)) { // run this loop until our condition will get satisfied
			num++;
			shuffle_cards(cards, players);
		}
		System.out.println("No. of times cards got shuffled to satisfy condition: " + num);

		for (int i = 0; i < players.size(); i++) { // printing cards contained by each player
			System.out.print(players.get(i).toString() + " : ");
			for (int j = 0; j < 13; j++) {
				System.out.print(players.get(i).c.get(j).toString() + ", ");
			}
			System.out.println();
		}

	}

}
