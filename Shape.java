package setSolver;

// Enum shape contains the possible color attributes for the card
public enum Shape{
	// Shapes
	DIAMOND, SQUIGGLE, OVAL;
	
	// Returns the card code for each shape
	public String getCode() {
		if(this == DIAMOND) {
			return "D";
		} if (this == SQUIGGLE) {
			return "S";
		} else {
			return "O";
		}
	}
}
