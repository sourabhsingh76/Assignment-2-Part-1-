package games;

public class Card {
	String name;
	int number;
	boolean is_face, is_spade;
	
    public Card(String name, int number){
        this.name = name;
        this.number = number;
        this.is_face = false;
        
        if(number == 1 || number >= 11){   // Ace and Face Cards
            this.is_face = true;
        }

        this.is_spade = false;
        if(name == "SPADE"){
            this.is_spade = true;
        }
    }
    
	@Override
	public String toString() {
		return name+number;
	}
    
	
}
