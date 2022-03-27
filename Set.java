package setSolver;

import java.util.HashSet;

// Set class represents a set of 3 cards
public class Set {
	
	// A set is represented by a HashSet of cards
	HashSet<Card> set;
	
	// Creates the set with the three cards as parameters
	public Set(Card card1, Card card2, Card card3) {
		set = new HashSet<Card>();
		set.add(card1);
		set.add(card2);
		set.add(card3);
	}
	
	// equals method returns true if each of the three cards in one set are contained in the other
	public boolean equals(Set other) {
		for(Card cThis : this.set) {
			boolean foundCard = false;
			for(Card cOther : other.set) {
				if(cThis.equals(cOther)) {
					foundCard = true;
					break;
				}
			}
			if(!foundCard) {
				return false;
			}
		}
		return true;
	}
	
	// toString method returns each of the three card codes separated by a space
	public String toString() {
		String s = "";
		for(Card c : set) {
			s += c.toString() + " ";
		}
		return s;
	}
	
	// drawSet calls drawCard on each of the cards, drawing the three cards on the terminal
	public void drawSet() {
		for(Card c : set) {
			c.drawCard();
		}
		System.out.println("\n");
	}
	
}
