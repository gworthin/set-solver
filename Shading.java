package setSolver;

// Enum shading contains the possible color attributes for the card
public enum Shading {
	// Shading
	FULL, STRIPED, EMPTY;
	
	// Returns the code for each shading
	public String getCode() {
		if(this == FULL) {
			return "F";
		} if (this == STRIPED) {
			return "S";
		} else {
			return "E";
		}
	}
	
}
