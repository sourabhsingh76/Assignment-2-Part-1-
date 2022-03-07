package games;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
	
    public void shuffle_cards(ArrayList<Card> cards){
        Random rand = new Random();     
        for (int i = 0; i < cards.size() ; i++)     //shuffling cards  
        {
            int r = i + rand.nextInt(cards.size() - i);  //getting value of r in the range from 0 to cards.size()-i
            
             //swapping the elements
             Card temp = cards.get(r);
             cards.set(r, cards.get(i));
             cards.set(i, temp);  
        }
    }
 
    public boolean check(ArrayList<Card> cards){    // Check if each player has one spade and one face-card
        
        int player_found = 0;
        for(int player = 1; player <= 4; player++){
            boolean spade_found = false, face_found = false;
            for(int i = (player - 1) * 13; i < player * 13; i++){
                face_found = face_found || cards.get(i).is_face;
                spade_found = spade_found || cards.get(i).is_spade;
            }
            if(spade_found && face_found){
                player_found += 1;
            }
        }
        return (player_found == 4);
    } 
    
    public void run_infinite(ArrayList<Card> cards){

        int times_found = 0;
        while(!check(cards)){
            times_found++;
            shuffle_cards(cards);
        }
        System.out.println("No. of times cards got shuffled to satisfy condition: " + times_found);
        
        for(int player = 1; player <= 4; player++){
        	System.out.print("PLAYER " + player + ": ");
            for(int i = (player - 1) * 13; i < player * 13; i++){
            	System.out.print(cards.get(i).toString() + ", "); 
            }
            System.out.println();
        }
    }

}
