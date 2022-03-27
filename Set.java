package setSolver;

import java.util.HashSet;

public class Set {
	
	HashSet<Card> set;
	
	public Set(Card card1, Card card2, Card card3) {
		set = new HashSet<Card>();
		set.add(card1);
		set.add(card2);
		set.add(card3);
	}
	
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
	
	public String toString() {
		String s = "";
		for(Card c : set) {
			s += c.toString() + " ";
		}
		return s;
	}
	
	public void drawSet() {
		for(Card c : set) {
			c.drawCard();
		}
		System.out.println("\n");
	}
	
}
