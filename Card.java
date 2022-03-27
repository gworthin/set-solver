package setSolver;

// Card class represents a card in the game. It has attributed for number, color, shading and shape
public class Card {
	
	// Attributes of a card, all enums
	public Number number;
	public Color color;
	public Shading shading;
	public Shape shape;
	
	// Constructor by passing in each of the attributes
	public Card(Number number, Color color, Shading shading, Shape shape) {
		this.number = number;
		this.shape = shape;
		this.shading = shading;
		this.color = color;
	}
	
	// Constructor by taking in a 4 letter string, with each letter representing a specific attribute
	// This method assumes it's a 4 letter string and throws and IllegalArgumentException if it isn't a valid card
	public Card(String cardCode) {
		
		// Take the substrings for each letter
		String numberStr = cardCode.substring(0, 1);
		String colorStr = cardCode.substring(1, 2);
		String shadingStr = cardCode.substring(2, 3);
		String shapeStr = cardCode.substring(3, 4);
		
		// Assigns the number
		if(numberStr.equals("1")) {
			this.number = Number.ONE;
		} else if(numberStr.equals("2")) {
			this.number = Number.TWO;
		} else if(numberStr.equals("3")){
			this.number = Number.THREE;
		} else {
			throw new IllegalArgumentException();
		}
		
		// Assigns the color
		if(colorStr.equals("R")) {
			this.color = Color.RED;
		} else if(colorStr.equals("G")) {
			this.color = Color.GREEN;
		} else if(colorStr.equals("P")){
			this.color = Color.PURPLE;
		} else {
			throw new IllegalArgumentException();
		}
		
		// Assigns the shading
		if(shadingStr.equals("F")) {
			this.shading = Shading.FULL;
		} else if(shadingStr.equals("S")) {
			this.shading = Shading.STRIPED;
		} else if(shadingStr.equals("E")){
			this.shading = Shading.EMPTY;
		} else {
			throw new IllegalArgumentException();
		}
		
		// Assigns the shape
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
	
	// Equals method checks if two cards have the same four attributes
	public boolean equals(Card other) {
		if(other.number == this.number && other.shape == this.shape && other.shading == this.shading && other.color == this.color) {
			return true;
		}
		return false;
	}
	
	// toString method returns the 4-letter card code.
	public String toString() {
		return this.number.getCode() + this.color.getCode() + this.shading.getCode() + this.shape.getCode();
	}
	
	// Drawcard uses printNum method to draw the card in the terminal similar to how it looks in real life
	public void drawCard() {
		String s = "0"; // Set the string to be "0" (cards will be drawn using 0s)
		int num = this.number.getInt();
		
		if(this.shape == Shape.OVAL) {
			// Empty oval
			if(this.shading == Shading.EMPTY) {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 5; j++) {
					printNum("  " + s + "   " + s + "  ", num, this.color);
				}
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			// Striped oval
			} else if(this.shading == Shading.STRIPED) {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 2; j++) {
					printNum("  " + s + "   " + s + "  ", num, this.color);
					printNum("  " + s + s + s + s + s + "  ", num, this.color);
				}
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			// Full oval
			} else {
				printNum("   " + s + s + s + "   ", num, this.color);
				for(int j = 0; j < 5; j++) {
					printNum("  " + s + s + s + s + s + "  ", num, this.color);
				}
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			}
		} else if(this.shape == Shape.DIAMOND) {
			// Empty diamond
			if(this.shading == Shading.EMPTY) {
				printNum("    " + s + "    ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + "     "  + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("    " + s + "    ", num, this.color);
				System.out.println();
			// Striped diamon
			} else if(this.shading == Shading.STRIPED) {
				printNum("    " + s + "    ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum(" " + s + "     "  + s + " ", num, this.color);
				printNum("  " + s + s + s + s + s + "  ", num, this.color);
				printNum("   " + s + " " + s + "   ", num, this.color);
				printNum("    " + s + "    ", num, this.color);
				System.out.println();
			// Full diamond
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
			// Empty squiggle
			if(this.shading == Shading.EMPTY) {
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + "   " + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + "   " + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			// Striped squiggle
			} else if(this.shading == Shading.STRIPED) {
				printNum("   " + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + s + s + " ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum(" " + s + s + s + s + s + "   ", num, this.color);
				printNum("  " + s + "   " + s + "  ", num, this.color);
				printNum("   " + s + s + s + "   ", num, this.color);
				System.out.println();
			// Full squiggle
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
	
	// printNum method takes in the string to print, the number of times to print it (number of shapes on the card) and the color to print it in
	private void printNum(String s, int num, Color color) {
		String escape = "";
		// Determine the color for printing
		if(color == Color.RED) {
			escape = "\033[31m"; 
		} else if(color == Color.GREEN) {
			escape = "\033[32m";
		} else {
			escape = "\033[35m";
		}
		
		// Print num number of times
		for(int i = 0; i < num; i++) {
			System.out.print(escape + s + "  ");
		}
		System.out.println(); // new line
	}
	

}


