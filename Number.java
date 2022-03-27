package setSolver;

public enum Number {
	ONE, TWO, THREE;
	
	public int getInt() {
		if(this == ONE) {
			return 1;
		} else if (this == TWO) {
			return 2;
		} else {
			return 3;
		}
	}
	
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
