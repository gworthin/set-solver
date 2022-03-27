package setSolver;

// Enum color contains the possible color attributes for the card
public enum Color {
	// Colors
	RED, GREEN, PURPLE; 
	
	// String codes
	public String getCode() {
		if(this == RED) {
			return "R";
		} else if (this == GREEN) {
			return "G";
		} else {
			return "P";
		}
	}
	
}
