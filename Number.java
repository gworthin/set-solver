package setSolver;

// Enum number contains the possible color attributes for the card
public enum Number {
	// Numbers
	ONE, TWO, THREE;
	
	// Returns integer representations
	public int getInt() {
		if(this == ONE) {
			return 1;
		} else if (this == TWO) {
			return 2;
		} else {
			return 3;
		}
	}
	
	// Returns codes
	public String getCode() {
		if(this == ONE) {
			return "1";
		} if (this == TWO) {
			return "2";
		} else {
			return "3";
		}
	}
}
