package setSolver;

public enum Shape{
	
	DIAMOND, SQUIGGLE, OVAL;
	
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