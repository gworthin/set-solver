package setSolver;

public class Card {
	
	public Number number;
	public Color color;
	public Shading shading;
	public Shape shape;
	
	public Card(Number number, Color color, Shading shading, Shape shape) {
		this.number = number;
		this.shape = shape;
		this.shading = shading;
		this.color = color;
	}
	
	public Card(String cardCode) {
		String numberStr = cardCode.substring(0, 1);
		String colorStr = cardCode.substring(1, 2);
		String shadingStr = cardCode.substring(2, 3);
		String shapeStr = cardCode.substring(3, 4);
			
		if(numberStr.equals("1")) {
			this.number = Number.ONE;
		} else if(numberStr.equals("2")) {
			this.number = Number.TWO;
		} else if(numberStr.equals("3")){
			this.number = Number.THREE;
		} else {
			throw new IllegalArgumentException();
		}
		
		if(colorStr.equals("R")) {
			this.color = Color.RED;
		} else if(colorStr.equals("G")) {
			this.color = Color.GREEN;
		} else if(colorStr.equals("P")){
			this.color = Color.PURPLE;
		} else {
			throw new IllegalArgumentException();
		}
		
		if(shadingStr.equals("F")) {
			this.shading = Shading.FULL;
		} else if(shadingStr.equals("S")) {
			this.shading = Shading.STRIPED;
		} else if(shadingStr.equals("E")){
			this.shading = Shading.EMPTY;
		} else {
			throw new IllegalArgumentException();
		}
		
		if(shapeStr.equals("D")) {
			this.shape = Shape.DIAMOND;
		} else if(shapeStr.equals("S")) {
			this.shape = Shape.SQUIGGLE;
		} else if(shapeStr.equals("O")){
			this.shape = Shape.OVAL;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	public boolean equals(Card other) {
		if(other.number == this.number && other.shape == this.shape && other.shading == this.shading && other.color == this.color) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.number.getCode() + this.color.getCode() + this.shading.getCode() + this.shape.getCode();
	}
	
	public void drawCard() {
		String s = "0"
				+ "";
		int num = this.number.getInt();
		
		if(this.shape == Shape.OVAL) {
			if(this.shading == Shading.EMPTY) {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 5; j++) {
					printNum("  " + s + "   " + s + "  ", num, this.color);
				}
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			} else if(this.shading == Shading.STRIPED) {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 2; j++) {
					printNum("  " + s + "   " + s + "  ", num, this.color);
					printNum("  " + s + s + s + s + s + "  ", num, this.color);
				}
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			} else {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 5; j++) {
					printNum("  " + s + s + s + s + s + "  ", num, this.color);
				}
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			}
		} else if(this.shape == Shape.DIAMOND) {
			if(this.shading == Shading.EMPTY) {
				printNum("    " + s + "    ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + "     "  + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("    " + s + "    ", num, this.color);
				System.out.println();
			} else if(this.shading == Shading.STRIPED) {
				printNum("    " + s + "    ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum(" " + s + "     "  + s + " ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("    " + s + "    ", num, this.color);
				System.out.println();
			} else {
				printNum("    " + s + "    ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum(" " + s + s + s + s + s + s + s + " ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("    " + s + "    ", num, this.color);
				System.out.println();
			}
		} else {
			if(this.shading == Shading.EMPTY) {
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + "   " + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + "   " + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			} else if(this.shading == Shading.STRIPED) {
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + s + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + s + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			} else {
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum("   " + s + s + s + s + s + " ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum(" " + s + s + s + s + s + "   ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			}	
		}
	}
	
	private void printNum(String s, int num, Color color) {
		String escape = "";
		if(color == Color.RED) {
			escape = "\033[31m";
		} else if(color == Color.GREEN) {
			escape = "\033[32m";
		} else {
			escape = "\033[35m";
		}
		
		for(int i = 0; i < num; i++) {
			System.out.print(escape + s + "  ");
		}
		System.out.println();
	}
	

}


