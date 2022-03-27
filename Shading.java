package setSolver;

public enum Shading {
	
	FULL, STRIPED, EMPTY;
	
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
