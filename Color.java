package setSolver;

public enum Color {
	RED, GREEN, PURPLE;
	
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
